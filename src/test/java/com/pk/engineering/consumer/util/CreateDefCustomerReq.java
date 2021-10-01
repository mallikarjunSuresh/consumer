package com.pk.engineering.consumer.util;

import java.time.LocalDate;
import com.pk.engineering.consumer.model.mq.CustomerAddress;
import com.pk.engineering.consumer.model.mq.CustomerRequest;
import com.pk.engineering.consumer.model.mq.CustomerRequest.CustomerStatusEnum;

public class CreateDefCustomerReq {
  
  public static CustomerRequest getDefCustomerReq() {

    CustomerRequest customerRequest = new CustomerRequest();
    CustomerAddress address = new CustomerAddress();
    address.setAddressLine1("Guindy");
    address.setPostalCode("12345");
    customerRequest.setCustomerNumber("C000000001");
    customerRequest.setAddress(address);
    customerRequest.setBirthDate(LocalDate.of(1996, 8, 14));
    customerRequest.setCountry("India");
    customerRequest.setCountryCode(21);
    customerRequest.setCustomerStatus(CustomerStatusEnum.OPEN);
    customerRequest.setEmail("arjun@gmail.com");
    customerRequest.setFistName("Mallikarjun");
    customerRequest.setLastName("SureshKumar");
    customerRequest.setMobileNumber(1234567899L);

    return customerRequest;
  }
}
