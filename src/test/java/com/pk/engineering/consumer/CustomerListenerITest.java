package com.pk.engineering.consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.util.concurrent.ListenableFuture;
import com.jayway.awaitility.Awaitility;
import com.pk.engineering.consumer.conf.ConsumerKafkaTestConfig;
import com.pk.engineering.consumer.model.db.AuditLog;
import com.pk.engineering.consumer.model.db.ErrorLog;
import com.pk.engineering.consumer.model.mq.CustomerKafkaPayload;
import com.pk.engineering.consumer.model.mq.GenericKafkaEvent;
import com.pk.engineering.consumer.service.AuditLogService;
import com.pk.engineering.consumer.service.ErrorLogService;
import com.pk.engineering.consumer.util.CreateCustomerKafkaEvent;

@SpringBootTest
@Import(ConsumerKafkaTestConfig.class)
@EmbeddedKafka(partitions = 1,
    brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092","log.dirs=C:/Users/smallikarjun/AppData/Local/Kafka"}, topics = {"customer"})
class CustomerListenerITest {

  @Autowired
  private KafkaTemplate<String, Object> kafkaTemplate;

  @Autowired
  private AuditLogService auditLogService;
  
  @Autowired
  private ErrorLogService errorLogService;

  @Test
  void testCustomerKafkaListenerWhenCustomerKafkaEventWithInfoPublishedShouldPersistInAuditTable() {

    // Given
    GenericKafkaEvent<CustomerKafkaPayload> queuePayload = CreateCustomerKafkaEvent.defKafkaQueuePayload();    
    ListenableFuture<SendResult<String, Object>> future =
        kafkaTemplate.send("customer", queuePayload);    
    Awaitility.await().timeout(2, TimeUnit.SECONDS).until(()->{
      try {
        future.get();
      } catch (InterruptedException | ExecutionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });


    // Then
    List<AuditLog> auditLogs = auditLogService.getAllAuditLog();

    assertEquals(auditLogs.get(0).getCustomerNumber(),
        queuePayload.getCustomerPayload().getCustomerRequest().getCustomerNumber());

  }
  
  @Test
  void testCustomerKafkaListenerWhenCustomerKafkaEventWithErrorPublishedShouldPersistInErrorTable() {

    // Given
    LinkedHashMap<String, String> errorQueuePayload 
        = new LinkedHashMap<String, String>();
    errorQueuePayload.putIfAbsent("string", "payload");
    
    ListenableFuture<SendResult<String, Object>> future =
        kafkaTemplate.send("customer", errorQueuePayload);
    Awaitility.await().timeout(2, TimeUnit.SECONDS).until(()->{
      try {
        future.get();
      } catch (InterruptedException | ExecutionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });

    // Then
    List<ErrorLog> actErroLogs = errorLogService.getAllErrorLog();
    String expError = "Listener failed; nested exception is org.springframework.kafka.KafkaException: No method found for class java.util.LinkedHashMap";
    assertEquals(actErroLogs.get(0).getErrorDescription(),expError);

  }
  

}

