package com.carrefour.shopping.ordermanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.ordermanagement.logic.api.to.OrderCto;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderEto;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderSearchCriteriaTo;

public interface UcFindOrder {

  /**
   * Returns a Order by its id 'id'.
   *
   * @param id The id 'id' of the Order.
   * @return The {@link OrderEto} with id 'id'
   */
  OrderEto findOrder(long id);

  /**
   * Returns a paginated list of Orders matching the search criteria.
   *
   * @param criteria the {@link OrderSearchCriteriaTo}.
   * @return the {@link List} of matching {@link OrderEto}s.
   */
  Page<OrderEto> findOrders(OrderSearchCriteriaTo criteria);

  /**
   * Returns a composite Order by its id 'id'.
   *
   * @param id The id 'id' of the Order.
   * @return The {@link OrderCto} with id 'id'
   */
  OrderCto findOrderCto(long id);

  /**
   * Returns a paginated list of composite Orders matching the search criteria.
   *
   * @param criteria the {@link OrderSearchCriteriaTo}.
   * @return the {@link List} of matching {@link OrderCto}s.
   */
  Page<OrderCto> findOrderCtos(OrderSearchCriteriaTo criteria);

}
