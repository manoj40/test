package com.carrefour.shopping.ordermanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Order
 */
public class OrderCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private OrderEto order;

  public OrderEto getOrder() {

    return order;
  }

  public void setOrder(OrderEto order) {

    this.order = order;
  }

}
