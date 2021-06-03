package com.carrefour.shopping.productmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.general.logic.base.AbstractComponentFacade;
import com.carrefour.shopping.productmanagement.logic.api.Productmanagement;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductCto;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductEto;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.carrefour.shopping.productmanagement.logic.api.usecase.UcFindProduct;
import com.carrefour.shopping.productmanagement.logic.api.usecase.UcManageProduct;

/**
 * Implementation of component interface of productmanagement
 */
@Named
public class ProductmanagementImpl extends AbstractComponentFacade implements Productmanagement {

  @Inject
  private UcFindProduct ucFindProduct;

  @Inject
  private UcManageProduct ucManageProduct;

  @Override
  public ProductEto findProduct(long id) {

    return this.ucFindProduct.findProduct(id);
  }

  @Override
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo criteria) {

    return this.ucFindProduct.findProducts(criteria);
  }

  @Override
  public ProductEto saveProduct(ProductEto product) {

    return this.ucManageProduct.saveProduct(product);
  }

  @Override
  public boolean deleteProduct(long id) {

    return this.ucManageProduct.deleteProduct(id);
  }

  @Override
  public ProductCto findProductCto(long id) {

    return ucFindProduct.findProductCto(id);
  }

  @Override
  public Page<ProductCto> findProductCtos(ProductSearchCriteriaTo criteria) {

    return ucFindProduct.findProductCtos(criteria);
  }

}
