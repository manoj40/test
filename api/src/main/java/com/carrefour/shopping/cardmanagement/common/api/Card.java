package com.carrefour.shopping.cardmanagement.common.api;

import com.carrefour.shopping.general.common.api.ApplicationEntity;

public interface Card extends ApplicationEntity {

  /**
   * @return creditCardNumberId
   */

  public String getCreditCardNumber();

  /**
   * @param creditCardNumber setter for creditCardNumber attribute
   */

  public void setCreditCardNumber(String creditCardNumber);

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
   * @return statusId
   */

  public String getStatus();

  /**
   * @param status setter for status attribute
   */

  public void setStatus(String status);

}
