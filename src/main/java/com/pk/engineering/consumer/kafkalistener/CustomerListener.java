package com.pk.engineering.consumer.kafkalistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.pk.engineering.consumer.converter.KafkaQueuePayloadToAuditLogConverter;
import com.pk.engineering.consumer.model.db.AuditLog;
import com.pk.engineering.consumer.model.mq.CustomerKafkaPayload;
import com.pk.engineering.consumer.model.mq.GenericKafkaEvent;
import com.pk.engineering.consumer.service.AuditLogService;

@Component
@KafkaListener(id = "CustomerListener", topics = "customer")
public class CustomerListener {

  private static final Logger log = LoggerFactory.getLogger(CustomerListener.class);
  
  @Autowired
  private AuditLogService auditLogService;

  @KafkaHandler
  public void defListener(@Payload GenericKafkaEvent<CustomerKafkaPayload> message,
      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {

    log.info("Received CustomerKafkaEvent :{}", message);
    
    AuditLog auditLog = new KafkaQueuePayloadToAuditLogConverter().apply(message);
    auditLogService.createAuditLog(auditLog);
    
    log.info("CustomerKafkaEvent persisted into db :{}", message);

  }

}
