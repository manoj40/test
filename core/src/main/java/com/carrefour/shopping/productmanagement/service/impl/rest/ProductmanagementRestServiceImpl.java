package com.carrefour.shopping.productmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.productmanagement.logic.api.Productmanagement;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductCto;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductEto;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.carrefour.shopping.productmanagement.service.api.rest.ProductmanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Productmanagement}.
 */
@Named("ProductmanagementRestService")
public class ProductmanagementRestServiceImpl implements ProductmanagementRestService {

  @Inject
  private Productmanagement productmanagement;

  @Override
  public ProductEto getProduct(long id) {

    return this.productmanagement.findProduct(id);
  }

  @Override
  public ProductEto saveProduct(ProductEto product) {

    return this.productmanagement.saveProduct(product);
  }

  @Override
  public void deleteProduct(long id) {

    this.productmanagement.deleteProduct(id);
  }

  @Override
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo searchCriteriaTo) {

    return this.productmanagement.findProducts(searchCriteriaTo);
  }

  @Override
  public ProductCto getProductCto(long id) {

    return this.productmanagement.findProductCto(id);
  }

  @Override
  public Page<ProductCto> findProductCtos(ProductSearchCriteriaTo searchCriteriaTo) {

    return this.productmanagement.findProductCtos(searchCriteriaTo);
  }

}
