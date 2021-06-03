package com.carrefour.shopping.ordermanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.ordermanagement.logic.api.Ordermanagement;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderCto;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderEto;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import com.carrefour.shopping.ordermanagement.service.api.rest.OrdermanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Ordermanagement}.
 */
@Named("OrdermanagementRestService")
public class OrdermanagementRestServiceImpl implements OrdermanagementRestService {

  @Inject
  private Ordermanagement ordermanagement;

  @Override
  public OrderEto getOrder(long id) {

    return this.ordermanagement.findOrder(id);
  }

  @Override
  public OrderEto saveOrder(OrderEto order) {

    return this.ordermanagement.saveOrder(order);
  }

  @Override
  public void deleteOrder(long id) {

    this.ordermanagement.deleteOrder(id);
  }

  @Override
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findOrders(searchCriteriaTo);
  }

  @Override
  public OrderCto getOrderCto(long id) {

    return this.ordermanagement.findOrderCto(id);
  }

  @Override
  public Page<OrderCto> findOrderCtos(OrderSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findOrderCtos(searchCriteriaTo);
  }

}
