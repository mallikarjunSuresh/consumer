package com.pk.engineering.consumer.model.mq;

import java.time.LocalDate;
import java.util.Objects;


public class CustomerRequest {

  private String customerNumber = null;

  private String fistName = null;

  private String lastName = null;

  private LocalDate birthDate = null;

  private String country = null;

  private Integer countryCode = null;

  private Long mobileNumber = null;

  private String email = null;

  public enum CustomerStatusEnum {
    OPEN("Open"),

    CLOSE("Close"),

    SUSPENDED("Suspended"),

    RESTORED("Restored");

    private String value;

    CustomerStatusEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

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

  public CustomerRequest customerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
    return this;
  }

  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public CustomerRequest fistName(String fistName) {
    this.fistName = fistName;
    return this;
  }

  public String getFistName() {
    return fistName;
  }

  public void setFistName(String fistName) {
    this.fistName = fistName;
  }

  public CustomerRequest lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CustomerRequest birthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public CustomerRequest country(String country) {
    this.country = country;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public CustomerRequest countryCode(Integer countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  public Integer getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(Integer countryCode) {
    this.countryCode = countryCode;
  }

  public CustomerRequest mobileNumber(Long mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  public Long getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(Long mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public CustomerRequest email(String email) {
    this.email = email;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CustomerRequest customerStatus(CustomerStatusEnum customerStatus) {
    this.customerStatus = customerStatus;
    return this;
  }

  public CustomerStatusEnum getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(CustomerStatusEnum customerStatus) {
    this.customerStatus = customerStatus;
  }

  public CustomerRequest address(CustomerAddress address) {
    this.address = address;
    return this;
  }

  public CustomerAddress getAddress() {
    return address;
  }

  public void setAddress(CustomerAddress address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerRequest request = (CustomerRequest) o;
    return Objects.equals(this.customerNumber, request.customerNumber)
        && Objects.equals(this.fistName, request.fistName)
        && Objects.equals(this.lastName, request.lastName)
        && Objects.equals(this.birthDate, request.birthDate)
        && Objects.equals(this.country, request.country)
        && Objects.equals(this.countryCode, request.countryCode)
        && Objects.equals(this.mobileNumber, request.mobileNumber)
        && Objects.equals(this.email, request.email)
        && Objects.equals(this.customerStatus, request.customerStatus)
        && Objects.equals(this.address, request.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerNumber, fistName, lastName, birthDate, country, countryCode,
        mobileNumber, email, customerStatus, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {\n");

    sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
    sb.append("    fistName: ").append(toIndentedString(fistName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
