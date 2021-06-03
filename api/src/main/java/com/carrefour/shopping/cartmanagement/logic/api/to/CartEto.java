package com.carrefour.shopping.cartmanagement.logic.api.to;

import java.util.List;

import com.carrefour.shopping.cartmanagement.common.api.Cart;
import com.carrefour.shopping.productmanagement.common.api.to.ProductQuantityEto;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Cart
 */
public class CartEto extends AbstractEto implements Cart {

  private static final long serialVersionUID = 1L;

  private String userName;

  private List<ProductQuantityEto> products;

  @Override
  public String getUserName() {

    return userName;
  }

  @Override
  public void setUserName(String userName) {

    this.userName = userName;
  }

  @Override
  public List<ProductQuantityEto> getProducts() {

    return products;
  }

  @Override
  public void setProducts(List<ProductQuantityEto> products) {

    this.products = products;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.userName == null) ? 0 : this.userName.hashCode());
    result = prime * result + ((this.products == null) ? 0 : this.products.hashCode());
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
    CartEto other = (CartEto) obj;
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
    return true;
  }
}
