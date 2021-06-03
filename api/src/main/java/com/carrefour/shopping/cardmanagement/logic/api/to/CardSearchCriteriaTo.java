package com.carrefour.shopping.cardmanagement.logic.api.to;

import com.carrefour.shopping.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of {@link com.carrefour.shopping.cardmanagement.common.api.Card}s.
 */
public class CardSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String creditCardNumber;

  private String userName;

  private Double amount;

  private String status;

  private StringSearchConfigTo creditCardNumberOption;

  private StringSearchConfigTo userNameOption;

  private StringSearchConfigTo statusOption;

  /**
   * @return creditCardNumberId
   */

  public String getCreditCardNumber() {

    return creditCardNumber;
  }

  /**
   * @param creditCardNumber setter for creditCardNumber attribute
   */

  public void setCreditCardNumber(String creditCardNumber) {

    this.creditCardNumber = creditCardNumber;
  }

  /**
   * @return userNameId
   */

  public String getUserName() {

    return userName;
  }

  /**
   * @param userName setter for userName attribute
   */

  public void setUserName(String userName) {

    this.userName = userName;
  }

  /**
   * @return amountId
   */

  public Double getAmount() {

    return amount;
  }

  /**
   * @param amount setter for amount attribute
   */

  public void setAmount(Double amount) {

    this.amount = amount;
  }

  /**
   * @return statusId
   */

  public String getStatus() {

    return status;
  }

  /**
   * @param status setter for status attribute
   */

  public void setStatus(String status) {

    this.status = status;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getCreditCardNumber() creditCardNumber}.
   */
  public StringSearchConfigTo getCreditCardNumberOption() {

    return this.creditCardNumberOption;
  }

  /**
   * @param creditCardNumberOption new value of {@link #getCreditCardNumberOption()}.
   */
  public void setCreditCardNumberOption(StringSearchConfigTo creditCardNumberOption) {

    this.creditCardNumberOption = creditCardNumberOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getUserName() userName}.
   */
  public StringSearchConfigTo getUserNameOption() {

    return this.userNameOption;
  }

  /**
   * @param userNameOption new value of {@link #getUserNameOption()}.
   */
  public void setUserNameOption(StringSearchConfigTo userNameOption) {

    this.userNameOption = userNameOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getStatus() status}.
   */
  public StringSearchConfigTo getStatusOption() {

    return this.statusOption;
  }

  /**
   * @param statusOption new value of {@link #getStatusOption()}.
   */
  public void setStatusOption(StringSearchConfigTo statusOption) {

    this.statusOption = statusOption;
  }

}
