package com.pk.engineering.consumer.converter;

import com.pk.engineering.consumer.model.db.CustomerDbPayload;
import com.pk.engineering.consumer.model.mq.CustomerKafkaPayload;

public class CustomerKafkaPayloadToCustomerDbPayload implements GenericConverter<CustomerKafkaPayload, CustomerDbPayload>{
  @Override
  public CustomerDbPayload apply(final CustomerKafkaPayload mqPayload) {
    CustomerDbPayload payload = new CustomerDbPayload();

    
    payload.setActivityId(mqPayload.getActivityId());
    payload.setTransactionId(mqPayload.getTransactionId());
    payload.setCustomerNumber(mqPayload.getCustomerRequest().getCustomerNumber());
    payload.setFistName(mqPayload.getCustomerRequest().getFistName());        
    payload.setLastName(mqPayload.getCustomerRequest().getLastName());
    payload.setBirthDate(mqPayload.getCustomerRequest().getBirthDate());       
    payload.setCountry(mqPayload.getCustomerRequest().getCountry());
    payload.setCountryCode(mqPayload.getCustomerRequest().getCountryCode());
    payload.setMobileNumber(mqPayload.getCustomerRequest().getMobileNumber());
    payload.setEmail(mqPayload.getCustomerRequest().getEmail());
    
    switch(mqPayload.getCustomerRequest().getCustomerStatus()) {
      
      case OPEN:
        payload.setCustomerStatus(CustomerDbPayload.CustomerStatusEnum.OPEN);
        break;
        
      case CLOSE:
        payload.setCustomerStatus(CustomerDbPayload.CustomerStatusEnum.CLOSE);
        break;
        
      case RESTORED:
        payload.setCustomerStatus(CustomerDbPayload.CustomerStatusEnum.RESTORED);
        break;
        
      case SUSPENDED:
        payload.setCustomerStatus(CustomerDbPayload.CustomerStatusEnum.SUSPENDED);
        break;
        
      default:
        break;
    }
    
    payload.setAddress(mqPayload.getCustomerRequest().getAddress());
    return payload;
  }
}
