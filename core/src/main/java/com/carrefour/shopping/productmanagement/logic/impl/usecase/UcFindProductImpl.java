package com.carrefour.shopping.productmanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.carrefour.shopping.productmanagement.dataaccess.api.ProductEntity;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductCto;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductEto;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.carrefour.shopping.productmanagement.logic.api.usecase.UcFindProduct;
import com.carrefour.shopping.productmanagement.logic.base.usecase.AbstractProductUc;

/**
 * Use case implementation for searching, filtering and getting Products
 */
@Named
@Validated
@Transactional
public class UcFindProductImpl extends AbstractProductUc implements UcFindProduct {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindProductImpl.class);

  @Override
  public ProductEto findProduct(long id) {

    LOG.debug("Get Product with id {} from database.", id);
    Optional<ProductEntity> foundEntity = getProductRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), ProductEto.class);
    else
      return null;
  }

  @Override
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo criteria) {

    Page<ProductEntity> products = getProductRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(products, ProductEto.class);
  }

  @Override
  public ProductCto findProductCto(long id) {

    LOG.debug("Get ProductCto with id {} from database.", id);
    ProductEntity entity = getProductRepository().find(id);
    ProductCto cto = new ProductCto();
    cto.setProduct(getBeanMapper().map(entity, ProductEto.class));

    return cto;
  }

  @Override
  public Page<ProductCto> findProductCtos(ProductSearchCriteriaTo criteria) {

    Page<ProductEntity> products = getProductRepository().findByCriteria(criteria);
    List<ProductCto> ctos = new ArrayList<>();
    for (ProductEntity entity : products.getContent()) {
      ProductCto cto = new ProductCto();
      cto.setProduct(getBeanMapper().map(entity, ProductEto.class));
      ctos.add(cto);
    }
    Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(), criteria.getPageable().getPageSize());

    return new PageImpl<>(ctos, pagResultTo, products.getTotalElements());
  }

}
