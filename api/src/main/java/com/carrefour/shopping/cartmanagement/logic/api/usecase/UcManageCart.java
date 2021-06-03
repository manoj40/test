package com.carrefour.shopping.cartmanagement.logic.api.usecase;

import com.carrefour.shopping.cartmanagement.logic.api.to.CartEto;

/**
 * Interface of UcManageCart to centralize documentation and signatures of methods.
 */
public interface UcManageCart {

  /**
   * Deletes a cart from the database by its id 'cartId'.
   *
   * @param cartId Id of the cart to delete
   * @return boolean <code>true</code> if the cart can be deleted, <code>false</code> otherwise
   */
  boolean deleteCart(long cartId);

  /**
   * Saves a cart and store it in the database.
   *
   * @param cart the {@link CartEto} to create.
   * @return the new {@link CartEto} that has been saved with ID and version.
   */
  CartEto saveCart(CartEto cart);

}
