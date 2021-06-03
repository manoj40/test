package com.carrefour.shopping.common.api.builders;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import com.carrefour.shopping.cartmanagement.dataaccess.api.CartEntity;
import com.carrefour.shopping.productmanagement.common.api.to.ProductQuantityEto;

/**
 * Test data builder for CartEntity generated with cobigen.
 */
public class CartEntityBuilder {

  private List<Consumer<CartEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public CartEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param userName the userName to add.
   * @return the builder for fluent population of fields.
   */
  public CartEntityBuilder userName(final String userName) {

    this.parameterToBeApplied.add(target -> target.setUserName(userName));

    return this;
  }

  /**
   * @param products the products to add.
   * @return the builder for fluent population of fields.
   */
  public CartEntityBuilder products(final List<ProductQuantityEto> products) {

    this.parameterToBeApplied.add(target -> target.setProducts(products));

    return this;
  }

  /**
   * @return the populated CartEntity.
   */
  public CartEntity createNew() {

    CartEntity cartentity = new CartEntity();
    for (Consumer<CartEntity> parameter : this.parameterToBeApplied) {
      parameter.accept(cartentity);
    }
    return cartentity;
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
   * @return the CartEntity
   */
  public CartEntity persist(EntityManager em) {

    CartEntity cartentity = createNew();
    em.persist(cartentity);
    return cartentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of CartEntity
   */
  public List<CartEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<CartEntity> cartentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      CartEntity cartentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(cartentity);
      cartentityList.add(cartentity);
    }

    return cartentityList;
  }

}
