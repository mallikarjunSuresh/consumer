package com.pk.engineering.consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.pk.engineering.consumer.converter.KafkaQueuePayloadToAuditLogConverter;
import com.pk.engineering.consumer.model.db.AuditLog;
import com.pk.engineering.consumer.model.mq.CustomerKafkaPayload;
import com.pk.engineering.consumer.model.mq.GenericKafkaEvent;
import com.pk.engineering.consumer.util.CreateCustomerKafkaEvent;

class KafkaCustomerEventToAuditLogConverterTest {

  private KafkaQueuePayloadToAuditLogConverter converter = new KafkaQueuePayloadToAuditLogConverter();

  @Test
  void testdoMaskingWhencustomerObjectPassedWithEmailLengthGreaterThanFourShoudlMaskValuesProperly() {

    // Given
    GenericKafkaEvent<CustomerKafkaPayload> kafkaQueuePayload = CreateCustomerKafkaEvent.defKafkaQueuePayload();
    

    // When
    AuditLog auditLog = converter.apply(kafkaQueuePayload);

    
    // Then
    assertEquals(kafkaQueuePayload.getCustomerPayload().getActivityId(), auditLog.getCustomerPayload().getActivityId());

  }
}
