package com.pk.engineering.consumer.util;

import java.util.UUID;
import com.pk.engineering.consumer.model.mq.CustomerKafkaPayload;
import com.pk.engineering.consumer.model.mq.CustomerRequest;

public class CreateDefCustomerPayload {
  
  public static CustomerKafkaPayload getDefCustomerPayload() {
    String ActivityId = UUID.randomUUID().toString();
    String TransactionalId = UUID.randomUUID().toString();
    CustomerRequest customerResponse = CreateDefCustomerReq.getDefCustomerReq();
    return new CustomerKafkaPayload(ActivityId, TransactionalId, customerResponse);
    
  }
}
