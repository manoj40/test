package com.carrefour.shopping.paymentmanagement.common.api;

import com.carrefour.shopping.general.common.api.ApplicationEntity;

public interface Payment extends ApplicationEntity {

  /**
   * @return cardIdId
   */

  public Long getCardId();

  /**
   * @param cardId setter for cardId attribute
   */

  public void setCardId(Long cardId);

  /**
   * @return userNameId
   */

  public String getUserName();

  /**
   * @param userName setter for userName attribute
   */

  public void setUserName(String userName);

  /**
   * @return amountId
   */

  public Double getAmount();

  /**
   * @param amount setter for amount attribute
   */

  public void setAmount(Double amount);

  /**
   * @return paymentStatusId
   */

  public boolean isPaymentStatus();

  /**
   * @param paymentStatus setter for paymentStatus attribute
   */

  public void setPaymentStatus(boolean paymentStatus);

}
