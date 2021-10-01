package com.pk.engineering.consumer.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonType;

@Entity
@Table(name = "AUDIT_LOG")
@TypeDef(name = "json", typeClass = JsonType.class)
public class AuditLog {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="ID")
  private Long id;
  
  @Column(name="CUSTOMER_NUMBER", nullable = true)
  private String customerNumber;
  
  @Column(name="PAYLOAD",columnDefinition = "json",nullable = true)
  @Type(type = "json")
  private CustomerDbPayload customerPayload;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public CustomerDbPayload getCustomerPayload() {
    return customerPayload;
  }

  public void setCustomerPayload(CustomerDbPayload customerPayload) {
    this.customerPayload = customerPayload;
  }

  @Override
  public String toString() {
    return "AuditLog [id=" + id + ", customerNumber=" + customerNumber + ", customerPayload="
        + customerPayload + "]";
  }

    
}

