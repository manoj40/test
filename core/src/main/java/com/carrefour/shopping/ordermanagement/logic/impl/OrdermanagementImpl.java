package com.carrefour.shopping.ordermanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.general.logic.base.AbstractComponentFacade;
import com.carrefour.shopping.ordermanagement.logic.api.Ordermanagement;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderCto;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderEto;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import com.carrefour.shopping.ordermanagement.logic.api.usecase.UcFindOrder;
import com.carrefour.shopping.ordermanagement.logic.api.usecase.UcManageOrder;

/**
 * Implementation of component interface of ordermanagement
 */
@Named
public class OrdermanagementImpl extends AbstractComponentFacade implements Ordermanagement {

  @Inject
  private UcFindOrder ucFindOrder;

  @Inject
  private UcManageOrder ucManageOrder;

  @Override
  public OrderEto findOrder(long id) {

    return this.ucFindOrder.findOrder(id);
  }

  @Override
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo criteria) {

    return this.ucFindOrder.findOrders(criteria);
  }

  @Override
  public OrderEto saveOrder(OrderEto order) {

    return this.ucManageOrder.saveOrder(order);
  }

  @Override
  public boolean deleteOrder(long id) {

    return this.ucManageOrder.deleteOrder(id);
  }

  @Override
  public OrderCto findOrderCto(long id) {

    return ucFindOrder.findOrderCto(id);
  }

  @Override
  public Page<OrderCto> findOrderCtos(OrderSearchCriteriaTo criteria) {

    return ucFindOrder.findOrderCtos(criteria);
  }

}
