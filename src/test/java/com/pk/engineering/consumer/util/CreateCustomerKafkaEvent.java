package com.pk.engineering.consumer.util;

import com.pk.engineering.consumer.model.mq.CustomerKafkaPayload;
import com.pk.engineering.consumer.model.mq.GenericKafkaEvent;

public class CreateCustomerKafkaEvent {
  
  public static GenericKafkaEvent<CustomerKafkaPayload> defKafkaQueuePayload() {
    
    GenericKafkaEvent<CustomerKafkaPayload> queuePayload = new GenericKafkaEvent<>();

    queuePayload.setCustomerPayload(CreateDefCustomerPayload.getDefCustomerPayload());  
    
    return queuePayload;
  }
  
}