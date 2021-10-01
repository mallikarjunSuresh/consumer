package com.pk.engineering.consumer.converter;

import com.pk.engineering.consumer.model.db.AuditLog;
import com.pk.engineering.consumer.model.mq.CustomerKafkaPayload;
import com.pk.engineering.consumer.model.mq.GenericKafkaEvent;

public class KafkaQueuePayloadToAuditLogConverter implements GenericConverter<GenericKafkaEvent<CustomerKafkaPayload>, AuditLog> {

  @Override
  public AuditLog apply(GenericKafkaEvent<CustomerKafkaPayload> payload) {
    CustomerKafkaPayload mqPayload = payload.getCustomerPayload();
    AuditLog auditLog = new AuditLog();
    auditLog.setCustomerNumber(
        payload.getCustomerPayload().getCustomerRequest().getCustomerNumber());
    auditLog.setCustomerPayload(new CustomerKafkaPayloadToCustomerDbPayload().apply(mqPayload));
    return auditLog;
  }

}
