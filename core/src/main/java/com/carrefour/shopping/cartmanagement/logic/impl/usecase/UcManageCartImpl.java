package com.carrefour.shopping.cartmanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.carrefour.shopping.cartmanagement.dataaccess.api.CartEntity;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartEto;
import com.carrefour.shopping.cartmanagement.logic.api.usecase.UcManageCart;
import com.carrefour.shopping.cartmanagement.logic.base.usecase.AbstractCartUc;

/**
 * Use case implementation for modifying and deleting Carts
 */
@Named
@Validated
@Transactional
public class UcManageCartImpl extends AbstractCartUc implements UcManageCart {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageCartImpl.class);

  @Override
  public boolean deleteCart(long cartId) {

    CartEntity cart = getCartRepository().find(cartId);
    getCartRepository().delete(cart);
    LOG.debug("The cart with id '{}' has been deleted.", cartId);
    return true;
  }

  @Override
  public CartEto saveCart(CartEto cart) {

    Objects.requireNonNull(cart, "cart");

    CartEntity cartEntity = getBeanMapper().map(cart, CartEntity.class);

    // initialize, validate cartEntity here if necessary
    CartEntity resultEntity = getCartRepository().save(cartEntity);
    LOG.debug("Cart with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, CartEto.class);
  }
}
