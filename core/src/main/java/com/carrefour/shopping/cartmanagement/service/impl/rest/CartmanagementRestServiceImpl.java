package com.carrefour.shopping.cartmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.cartmanagement.logic.api.Cartmanagement;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartCto;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartEto;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartSearchCriteriaTo;
import com.carrefour.shopping.cartmanagement.service.api.rest.CartmanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Cartmanagement}.
 */
@Named("CartmanagementRestService")
public class CartmanagementRestServiceImpl implements CartmanagementRestService {

  @Inject
  private Cartmanagement cartmanagement;

  @Override
  public CartEto getCart(long id) {

    return this.cartmanagement.findCart(id);
  }

  @Override
  public CartEto saveCart(CartEto cart) {

    return this.cartmanagement.saveCart(cart);
  }

  @Override
  public void deleteCart(long id) {

    this.cartmanagement.deleteCart(id);
  }

  @Override
  public Page<CartEto> findCarts(CartSearchCriteriaTo searchCriteriaTo) {

    return this.cartmanagement.findCarts(searchCriteriaTo);
  }

  @Override
  public CartCto getCartCto(long id) {

    return this.cartmanagement.findCartCto(id);
  }

  @Override
  public Page<CartCto> findCartCtos(CartSearchCriteriaTo searchCriteriaTo) {

    return this.cartmanagement.findCartCtos(searchCriteriaTo);
  }

}
