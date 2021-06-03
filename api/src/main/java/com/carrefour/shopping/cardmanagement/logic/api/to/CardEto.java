package com.carrefour.shopping.cardmanagement.logic.api.to;

import com.carrefour.shopping.cardmanagement.common.api.Card;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Card
 */
public class CardEto extends AbstractEto implements Card {

  private static final long serialVersionUID = 1L;

  private String creditCardNumber;

  private String userName;

  private Double amount;

  private String status;

  @Override
  public String getCreditCardNumber() {

    return creditCardNumber;
  }

  @Override
  public void setCreditCardNumber(String creditCardNumber) {

    this.creditCardNumber = creditCardNumber;
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
  public String getStatus() {

    return status;
  }

  @Override
  public void setStatus(String status) {

    this.status = status;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.creditCardNumber == null) ? 0 : this.creditCardNumber.hashCode());
    result = prime * result + ((this.userName == null) ? 0 : this.userName.hashCode());
    result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
    result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
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
    CardEto other = (CardEto) obj;
    if (this.creditCardNumber == null) {
      if (other.creditCardNumber != null) {
        return false;
      }
    } else if (!this.creditCardNumber.equals(other.creditCardNumber)) {
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
    if (this.status == null) {
      if (other.status != null) {
        return false;
      }
    } else if (!this.status.equals(other.status)) {
      return false;
    }
    return true;
  }
}
