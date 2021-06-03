package com.carrefour.shopping.cartmanagement.logic.base.usecase;

import javax.inject.Inject;

import com.carrefour.shopping.cartmanagement.dataaccess.api.repo.CartRepository;
import com.carrefour.shopping.general.logic.base.AbstractUc;

/**
 * Abstract use case for Carts, which provides access to the commonly necessary data access objects.
 */
public class AbstractCartUc extends AbstractUc {

  /** @see #getCartRepository() */
  @Inject
  private CartRepository cartRepository;

  /**
   * Returns the field 'cartRepository'.
   * 
   * @return the {@link CartRepository} instance.
   */
  public CartRepository getCartRepository() {

    return this.cartRepository;
  }

}
