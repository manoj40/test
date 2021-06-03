package com.carrefour.shopping.ordermanagement.logic.api.to;

import java.time.LocalDateTime;

import com.carrefour.shopping.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of {@link com.carrefour.shopping.ordermanagement.common.api.Order}s.
 */
public class OrderSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String userName;

  private Double amount;

  private Boolean status;

  private LocalDateTime orderTime;

  private Long paymentId;

  private StringSearchConfigTo userNameOption;

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

  public Boolean getStatus() {

    return status;
  }

  /**
   * @param status setter for status attribute
   */

  public void setStatus(Boolean status) {

    this.status = status;
  }

  /**
   * @return orderTimeId
   */

  public LocalDateTime getOrderTime() {

    return orderTime;
  }

  /**
   * @param orderTime setter for orderTime attribute
   */

  public void setOrderTime(LocalDateTime orderTime) {

    this.orderTime = orderTime;
  }

  /**
   * @return paymentIdId
   */

  public Long getPaymentId() {

    return paymentId;
  }

  /**
   * @param paymentId setter for paymentId attribute
   */

  public void setPaymentId(Long paymentId) {

    this.paymentId = paymentId;
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

}
