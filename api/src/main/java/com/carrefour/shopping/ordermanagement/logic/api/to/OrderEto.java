package com.carrefour.shopping.ordermanagement.logic.api.to;

import java.time.LocalDateTime;
import java.util.List;

import com.carrefour.shopping.ordermanagement.common.api.Order;
import com.carrefour.shopping.productmanagement.common.api.to.ProductQuantityEto;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Order
 */
public class OrderEto extends AbstractEto implements Order {

  private static final long serialVersionUID = 1L;

  private String userName;

  private List<ProductQuantityEto> products;

  private Double amount;

  private LocalDateTime orderTime;

  @Override
  public String getUserName() {

    return this.userName;
  }

  @Override
  public void setUserName(String userName) {

    this.userName = userName;
  }

  @Override
  public List<ProductQuantityEto> getProducts() {

    return this.products;
  }

  @Override
  public void setProducts(List<ProductQuantityEto> products) {

    this.products = products;
  }

  @Override
  public Double getAmount() {

    return this.amount;
  }

  @Override
  public void setAmount(Double amount) {

    this.amount = amount;
  }

  @Override
  public LocalDateTime getOrderTime() {

    return this.orderTime;
  }

  @Override
  public void setOrderTime(LocalDateTime orderTime) {

    this.orderTime = orderTime;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.userName == null) ? 0 : this.userName.hashCode());
    result = prime * result + ((this.products == null) ? 0 : this.products.hashCode());
    result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
    result = prime * result + ((this.orderTime == null) ? 0 : this.orderTime.hashCode());
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
    OrderEto other = (OrderEto) obj;
    if (this.userName == null) {
      if (other.userName != null) {
        return false;
      }
    } else if (!this.userName.equals(other.userName)) {
      return false;
    }
    if (this.products == null) {
      if (other.products != null) {
        return false;
      }
    } else if (!this.products.equals(other.products)) {
      return false;
    }
    if (this.amount == null) {
      if (other.amount != null) {
        return false;
      }
    } else if (!this.amount.equals(other.amount)) {
      return false;
    }
    if (this.orderTime == null) {
      if (other.orderTime != null) {
        return false;
      }
    } else if (!this.orderTime.equals(other.orderTime)) {
      return false;
    }
    return true;
  }
}
