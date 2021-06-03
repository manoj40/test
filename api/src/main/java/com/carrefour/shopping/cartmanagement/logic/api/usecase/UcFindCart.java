package com.carrefour.shopping.cartmanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.cartmanagement.logic.api.to.CartCto;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartEto;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartSearchCriteriaTo;

public interface UcFindCart {

  /**
   * Returns a Cart by its id 'id'.
   *
   * @param id The id 'id' of the Cart.
   * @return The {@link CartEto} with id 'id'
   */
  CartEto findCart(long id);

  /**
   * Returns a paginated list of Carts matching the search criteria.
   *
   * @param criteria the {@link CartSearchCriteriaTo}.
   * @return the {@link List} of matching {@link CartEto}s.
   */
  Page<CartEto> findCarts(CartSearchCriteriaTo criteria);

  /**
   * Returns a composite Cart by its id 'id'.
   *
   * @param id The id 'id' of the Cart.
   * @return The {@link CartCto} with id 'id'
   */
  CartCto findCartCto(long id);

  /**
   * Returns a paginated list of composite Carts matching the search criteria.
   *
   * @param criteria the {@link CartSearchCriteriaTo}.
   * @return the {@link List} of matching {@link CartCto}s.
   */
  Page<CartCto> findCartCtos(CartSearchCriteriaTo criteria);

}
