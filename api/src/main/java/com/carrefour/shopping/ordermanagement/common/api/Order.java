package com.carrefour.shopping.ordermanagement.common.api;

import java.time.LocalDateTime;
import java.util.List;

import com.carrefour.shopping.general.common.api.ApplicationEntity;
import com.carrefour.shopping.productmanagement.common.api.to.ProductQuantityEto;

public interface Order extends ApplicationEntity {

  /**
   * @return userNameId
   */

  public String getUserName();

  /**
   * @param userName setter for userName attribute
   */

  public void setUserName(String userName);

  /**
   * @return productsId
   */

  public List<ProductQuantityEto> getProducts();

  /**
   * @param products setter for products attribute
   */

  public void setProducts(List<ProductQuantityEto> products);

  /**
   * @return amountId
   */

  public Double getAmount();

  /**
   * @param amount setter for amount attribute
   */

  public void setAmount(Double amount);

  /**
   * @return orderTimeId
   */

  public LocalDateTime getOrderTime();

  /**
   * @param orderTime setter for orderTime attribute
   */

  public void setOrderTime(LocalDateTime orderTime);

}
