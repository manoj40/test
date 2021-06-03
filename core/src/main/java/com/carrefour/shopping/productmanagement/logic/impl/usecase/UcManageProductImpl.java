package com.carrefour.shopping.productmanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.carrefour.shopping.productmanagement.dataaccess.api.ProductEntity;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductEto;
import com.carrefour.shopping.productmanagement.logic.api.usecase.UcManageProduct;
import com.carrefour.shopping.productmanagement.logic.base.usecase.AbstractProductUc;

/**
 * Use case implementation for modifying and deleting Products
 */
@Named
@Validated
@Transactional
public class UcManageProductImpl extends AbstractProductUc implements UcManageProduct {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageProductImpl.class);

  @Override
  public boolean deleteProduct(long productId) {

    ProductEntity product = getProductRepository().find(productId);
    getProductRepository().delete(product);
    LOG.debug("The product with id '{}' has been deleted.", productId);
    return true;
  }

  @Override
  public ProductEto saveProduct(ProductEto product) {

    Objects.requireNonNull(product, "product");

    ProductEntity productEntity = getBeanMapper().map(product, ProductEntity.class);

    // initialize, validate productEntity here if necessary
    ProductEntity resultEntity = getProductRepository().save(productEntity);
    LOG.debug("Product with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, ProductEto.class);
  }

}
