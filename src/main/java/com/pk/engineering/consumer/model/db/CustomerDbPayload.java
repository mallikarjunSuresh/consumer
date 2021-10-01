package com.pk.engineering.consumer.model.db;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.pk.engineering.consumer.model.mq.CustomerAddress;

public class CustomerDbPayload {

  private String activityId;

  private String transactionId;

  private String customerNumber = null;

  private String fistName = null;

  private String lastName = null;

  private LocalDate birthDate = null;

  private String country = null;

  private Integer countryCode = null;

  private Long mobileNumber = null;

  private String email = null;
  
  public enum CustomerStatusEnum {
    OPEN("O"),

    CLOSE("C"),

    SUSPENDED("S"),

    RESTORED("R");

    private String value;

    CustomerStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CustomerStatusEnum fromValue(String text) {
      for (CustomerStatusEnum b : CustomerStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  } 
  
  private CustomerStatusEnum customerStatus = null;

  private CustomerAddress address = null;

  public String getActivityId() {
    return activityId;
  }

  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public String getFistName() {
    return fistName;
  }

  public void setFistName(String fistName) {
    this.fistName = fistName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Integer getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(Integer countryCode) {
    this.countryCode = countryCode;
  }

  public Long getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(Long mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CustomerStatusEnum getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(CustomerStatusEnum customerStatus) {
    this.customerStatus = customerStatus;
  }

  public CustomerAddress getAddress() {
    return address;
  }

  public void setAddress(CustomerAddress address) {
    this.address = address;
  }
  
  
  
}
