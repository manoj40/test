package com.carrefour.shopping.common.api.builders;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import com.carrefour.shopping.productmanagement.dataaccess.api.ProductEntity;

/**
 * Test data builder for ProductEntity generated with cobigen.
 */
public class ProductEntityBuilder {

  private List<Consumer<ProductEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public ProductEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param name the name to add.
   * @return the builder for fluent population of fields.
   */
  public ProductEntityBuilder name(final String name) {

    this.parameterToBeApplied.add(target -> target.setName(name));

    return this;
  }

  /**
   * @param type the type to add.
   * @return the builder for fluent population of fields.
   */
  public ProductEntityBuilder category(final String category) {

    this.parameterToBeApplied.add(target -> target.setCategory(category));

    return this;
  }

  /**
   * @param quantity the quantity to add.
   * @return the builder for fluent population of fields.
   */
  public ProductEntityBuilder quantity(final Long quantity) {

    this.parameterToBeApplied.add(target -> target.setQuantity(quantity));

    return this;
  }

  /**
   * @param price the price to add.
   * @return the builder for fluent population of fields.
   */
  public ProductEntityBuilder price(final Double price) {

    this.parameterToBeApplied.add(target -> target.setPrice(price));

    return this;
  }

  /**
   * @return the populated ProductEntity.
   */
  public ProductEntity createNew() {

    ProductEntity productentity = new ProductEntity();
    for (Consumer<ProductEntity> parameter : this.parameterToBeApplied) {
      parameter.accept(productentity);
    }
    return productentity;
  }

  /**
   * Might be enriched to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  /**
   * @param em the {@link EntityManager}
   * @return the ProductEntity
   */
  public ProductEntity persist(EntityManager em) {

    ProductEntity productentity = createNew();
    em.persist(productentity);
    return productentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of ProductEntity
   */
  public List<ProductEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<ProductEntity> productentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      ProductEntity productentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(productentity);
      productentityList.add(productentity);
    }

    return productentityList;
  }

}
