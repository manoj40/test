package com.carrefour.shopping.cartmanagement.logic.impl.usecase;

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

import com.carrefour.shopping.cartmanagement.dataaccess.api.CartEntity;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartCto;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartEto;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartSearchCriteriaTo;
import com.carrefour.shopping.cartmanagement.logic.api.usecase.UcFindCart;
import com.carrefour.shopping.cartmanagement.logic.base.usecase.AbstractCartUc;

/**
 * Use case implementation for searching, filtering and getting Carts
 */
@Named
@Validated
@Transactional
public class UcFindCartImpl extends AbstractCartUc implements UcFindCart {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindCartImpl.class);

  @Override
  public CartEto findCart(long id) {

    LOG.debug("Get Cart with id {} from database.", id);
    Optional<CartEntity> foundEntity = getCartRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), CartEto.class);
    else
      return null;
  }

  @Override
  public Page<CartEto> findCarts(CartSearchCriteriaTo criteria) {

    Page<CartEntity> carts = getCartRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(carts, CartEto.class);
  }

  @Override
  public CartCto findCartCto(long id) {

    LOG.debug("Get CartCto with id {} from database.", id);
    CartEntity entity = getCartRepository().find(id);
    CartCto cto = new CartCto();
    cto.setCart(getBeanMapper().map(entity, CartEto.class));

    return cto;
  }

  @Override
  public Page<CartCto> findCartCtos(CartSearchCriteriaTo criteria) {

    Page<CartEntity> carts = getCartRepository().findByCriteria(criteria);
    List<CartCto> ctos = new ArrayList<>();
    for (CartEntity entity : carts.getContent()) {
      CartCto cto = new CartCto();
      cto.setCart(getBeanMapper().map(entity, CartEto.class));
      ctos.add(cto);
    }
    Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(), criteria.getPageable().getPageSize());

    return new PageImpl<>(ctos, pagResultTo, carts.getTotalElements());
  }

}
