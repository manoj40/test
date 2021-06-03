package com.carrefour.shopping.paymentmanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.carrefour.shopping.general.dataaccess.api.ApplicationPersistenceEntity;
import com.carrefour.shopping.paymentmanagement.common.api.Payment;

/**
 * TODO madwived This type ...
 */
@Entity
@Table(name = "Payment")
public class PaymentEntity extends ApplicationPersistenceEntity implements Payment {

  private Long cardId;

  private String userName;

  private Double amount;

  private boolean paymentStatus;

  private static final long serialVersionUID = 1L;

  /**
   * @return cardId
   */
  public Long getCardId() {

    return this.cardId;
  }

  /**
   * @param cardId new value of {@link #getcardId}.
   */
  public void setCardId(Long cardId) {

    this.cardId = cardId;
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
   * @return paymentStatus
   */
  public boolean isPaymentStatus() {

    return this.paymentStatus;
  }

  /**
   * @param paymentStatus new value of {@link #getpaymentStatus}.
   */
  public void setPaymentStatus(boolean paymentStatus) {

    this.paymentStatus = paymentStatus;
  }

}
