package com.pk.engineering.consumer.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonType;

@Entity
@Table(name = "ERROR_LOG")
@TypeDef(name = "json", typeClass = JsonType.class)
public class ErrorLog {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="ID")
  private Long id;
  
  @Column(name="ERROR_TYPE", nullable = true)
  private String errorType;
  
  @Lob
  @Column(name="ERROR_DESCRIPTION")
  private String errorDescription;  
  
  @Column(name="PAYLOAD",columnDefinition = "json",nullable = true)
  @Type(type = "json")
  private CustomerDbPayload customerPayload;
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getErrorType() {
    return errorType;
  }

  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }

  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  public CustomerDbPayload getCustomerPayload() {
    return customerPayload;
  }

  public void setCustomerPayload(CustomerDbPayload customerPayload) {
    this.customerPayload = customerPayload;
  }

  @Override
  public String toString() {
    return "ErrorLog [id=" + id + ", errorType=" + errorType + ", errorDescription="
        + errorDescription + ", customerPayload=" + customerPayload + "]";
  }


  
}
