package com.carrefour.shopping.paymentmanagement.logic.api.to;

import com.carrefour.shopping.paymentmanagement.common.api.Payment;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Payment
 */
public class PaymentEto extends AbstractEto implements Payment {

  private static final long serialVersionUID = 1L;

  private Long cardId;

  private String userName;

  private Double amount;

  private boolean paymentStatus;

  @Override
  public Long getCardId() {

    return cardId;
  }

  @Override
  public void setCardId(Long cardId) {

    this.cardId = cardId;
  }

  @Override
  public String getUserName() {

    return userName;
  }

  @Override
  public void setUserName(String userName) {

    this.userName = userName;
  }

  @Override
  public Double getAmount() {

    return amount;
  }

  @Override
  public void setAmount(Double amount) {

    this.amount = amount;
  }

  @Override
  public boolean isPaymentStatus() {

    return paymentStatus;
  }

  @Override
  public void setPaymentStatus(boolean paymentStatus) {

    this.paymentStatus = paymentStatus;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.cardId == null) ? 0 : this.cardId.hashCode());
    result = prime * result + ((this.userName == null) ? 0 : this.userName.hashCode());
    result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
    result = prime * result + ((Boolean) paymentStatus).hashCode();
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    PaymentEto other = (PaymentEto) obj;
    if (this.cardId == null) {
      if (other.cardId != null) {
        return false;
      }
    } else if (!this.cardId.equals(other.cardId)) {
      return false;
    }
    if (this.userName == null) {
      if (other.userName != null) {
        return false;
      }
    } else if (!this.userName.equals(other.userName)) {
      return false;
    }
    if (this.amount == null) {
      if (other.amount != null) {
        return false;
      }
    } else if (!this.amount.equals(other.amount)) {
      return false;
    }
    if (this.paymentStatus != other.paymentStatus) {
      return false;
    }
    return true;
  }
}
