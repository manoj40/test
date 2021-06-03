package com.carrefour.shopping.productmanagement.logic.base.usecase;

import javax.inject.Inject;

import com.carrefour.shopping.general.logic.base.AbstractUc;
import com.carrefour.shopping.productmanagement.dataaccess.api.repo.ProductRepository;

/**
 * Abstract use case for Products, which provides access to the commonly necessary data access objects.
 */
public class AbstractProductUc extends AbstractUc {

  /** @see #getProductRepository() */
  @Inject
  private ProductRepository productRepository;

  /**
   * Returns the field 'productRepository'.
   * 
   * @return the {@link ProductRepository} instance.
   */
  public ProductRepository getProductRepository() {

    return this.productRepository;
  }

}
