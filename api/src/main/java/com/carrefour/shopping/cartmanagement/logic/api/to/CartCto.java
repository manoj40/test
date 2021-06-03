package com.carrefour.shopping.cartmanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Cart
 */
public class CartCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private CartEto cart;

  public CartEto getCart() {

    return cart;
  }

  public void setCart(CartEto cart) {

    this.cart = cart;
  }

}
