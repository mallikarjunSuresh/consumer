package com.pk.engineering.consumer.model.mq;

import java.util.Objects;

public class CustomerKafkaPayload {

  private String activityId;

  private String transactionId;

  private CustomerRequest customerRequest;

  public CustomerKafkaPayload(String activityId, String transactionId, CustomerRequest customerRequest) {
    this.activityId = activityId;
    this.transactionId = transactionId;
    this.customerRequest = customerRequest;
  }


  public CustomerKafkaPayload() {}


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


  public CustomerRequest getCustomerRequest() {
    return customerRequest;
  }


  public void setCustomerRequest(CustomerRequest customerRequest) {
    this.customerRequest = customerRequest;
  }


  @Override
  public int hashCode() {
    return Objects.hash(activityId, transactionId, customerRequest);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CustomerKafkaPayload other = (CustomerKafkaPayload) obj;
    return Objects.equals(activityId, other.activityId)
        && Objects.equals(transactionId, other.transactionId)
        && Objects.equals(customerRequest, other.customerRequest);
  }

  @Override
  public String toString() {
    return "CustomerQueuePayload [activityId=" + activityId + ", transactionId=" + transactionId
        + ", customerRequest=" + customerRequest + "]";
  }



}
