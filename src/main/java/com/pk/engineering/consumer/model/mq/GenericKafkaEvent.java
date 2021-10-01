package com.pk.engineering.consumer.model.mq;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class GenericKafkaEvent<T> {

  @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,include = JsonTypeInfo.As.PROPERTY,property = "@class")
  private T customerPayload;

  public T getCustomerPayload() {
    return customerPayload;
  }

  public void setCustomerPayload(T customerPayload) {
    this.customerPayload = customerPayload;
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerPayload);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GenericKafkaEvent<T> other = (GenericKafkaEvent) obj;
    return Objects.equals(customerPayload, other.customerPayload);
  }

  @Override
  public String toString() {
    return "GenericKafkaEvent [customerPayload=" + customerPayload + "]";
  }

}
