package com.carrefour.shopping.cardmanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.carrefour.shopping.cardmanagement.common.api.Card;
import com.carrefour.shopping.general.dataaccess.api.ApplicationPersistenceEntity;

/**
 * TODO madwived This type ...
 */
@Entity
@Table(name = "Card")
public class CardEntity extends ApplicationPersistenceEntity implements Card {

  private String creditCardNumber;

  private String userName;

  private Double amount;

  private String status;

  private static final long serialVersionUID = 1L;

  /**
   * @return creditCardNumber
   */
  public String getCreditCardNumber() {

    return this.creditCardNumber;
  }

  /**
   * @param creditCardNumber new value of {@link #getcreditCardNumber}.
   */
  public void setCreditCardNumber(String creditCardNumber) {

    this.creditCardNumber = creditCardNumber;
  }

  /**
   * @return userName
   */
  public String getUserName() {

    return this.userName;
  }

  /**
   * @param userName new value of {@link #getuserName}.
   */
  public void setUserName(String userName) {

    this.userName = userName;
  }

  /**
   * @return amount
   */
  public Double getAmount() {

    return this.amount;
  }

  /**
   * @param amount new value of {@link #getamount}.
   */
  public void setAmount(Double amount) {

    this.amount = amount;
  }

  /**
   * @return status
   */
  public String getStatus() {

    return this.status;
  }

  /**
   * @param status new value of {@link #getstatus}.
   */
  public void setStatus(String status) {

    this.status = status;
  }

}
