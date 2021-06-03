package com.carrefour.shopping.ordermanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.carrefour.shopping.ordermanagement.dataaccess.api.OrderEntity;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderCto;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderEto;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import com.carrefour.shopping.ordermanagement.logic.api.usecase.UcFindOrder;
import com.carrefour.shopping.ordermanagement.logic.base.usecase.AbstractOrderUc;

/**
 * Use case implementation for searching, filtering and getting Orders
 */
@Named
@Validated
@Transactional
public class UcFindOrderImpl extends AbstractOrderUc implements UcFindOrder {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindOrderImpl.class);

  @Override
  public OrderEto findOrder(long id) {

    LOG.debug("Get Order with id {} from database.", id);
    Optional<OrderEntity> foundEntity = getOrderRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), OrderEto.class);
    else
      return null;
  }

  @Override
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo criteria) {

    Page<OrderEntity> orders = getOrderRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(orders, OrderEto.class);
  }

  @Override
  public OrderCto findOrderCto(long id) {

    LOG.debug("Get OrderCto with id {} from database.", id);
    OrderEntity entity = getOrderRepository().find(id);
    OrderCto cto = new OrderCto();
    cto.setOrder(getBeanMapper().map(entity, OrderEto.class));

    return cto;
  }

  @Override
  public Page<OrderCto> findOrderCtos(OrderSearchCriteriaTo criteria) {

    Page<OrderEntity> orders = getOrderRepository().findByCriteria(criteria);
    List<OrderCto> ctos = new ArrayList<>();
    for (OrderEntity entity : orders.getContent()) {
      OrderCto cto = new OrderCto();
      cto.setOrder(getBeanMapper().map(entity, OrderEto.class));
      ctos.add(cto);
    }
    Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(), criteria.getPageable().getPageSize());

    return new PageImpl<>(ctos, pagResultTo, orders.getTotalElements());
  }

}
