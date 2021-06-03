package com.carrefour.shopping.cartmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.cartmanagement.logic.api.Cartmanagement;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartCto;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartEto;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartSearchCriteriaTo;
import com.carrefour.shopping.cartmanagement.logic.api.usecase.UcFindCart;
import com.carrefour.shopping.cartmanagement.logic.api.usecase.UcManageCart;
import com.carrefour.shopping.general.logic.base.AbstractComponentFacade;

/**
 * Implementation of component interface of cartmanagement
 */
@Named
public class CartmanagementImpl extends AbstractComponentFacade implements Cartmanagement {

  @Inject
  private UcFindCart ucFindCart;

  @Inject
  private UcManageCart ucManageCart;

  @Override
  public CartEto findCart(long id) {

    return this.ucFindCart.findCart(id);
  }

  @Override
  public Page<CartEto> findCarts(CartSearchCriteriaTo criteria) {

    return this.ucFindCart.findCarts(criteria);
  }

  @Override
  public CartEto saveCart(CartEto cart) {

    return this.ucManageCart.saveCart(cart);
  }

  @Override
  public boolean deleteCart(long id) {

    return this.ucManageCart.deleteCart(id);
  }

  @Override
  public CartCto findCartCto(long id) {

    return ucFindCart.findCartCto(id);
  }

  @Override
  public Page<CartCto> findCartCtos(CartSearchCriteriaTo criteria) {

    return ucFindCart.findCartCtos(criteria);
  }

}
