package com.carrefour.shopping.common.api.builders;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import com.carrefour.shopping.ordermanagement.dataaccess.api.OrderEntity;
import com.carrefour.shopping.productmanagement.common.api.to.ProductQuantityEto;

/**
 * Test data builder for OrderEntity generated with cobigen.
 */
public class OrderEntityBuilder {

  private List<Consumer<OrderEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public OrderEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param userName the userName to add.
   * @return the builder for fluent population of fields.
   */
  public OrderEntityBuilder userName(final String userName) {

    this.parameterToBeApplied.add(target -> target.setUserName(userName));

    return this;
  }

  /**
   * @param products the products to add.
   * @return the builder for fluent population of fields.
   */
  public OrderEntityBuilder products(final List<ProductQuantityEto> products) {

    this.parameterToBeApplied.add(target -> target.setProducts(products));

    return this;
  }

  /**
   * @param amount the amount to add.
   * @return the builder for fluent population of fields.
   */
  public OrderEntityBuilder amount(final Double amount) {

    this.parameterToBeApplied.add(target -> target.setAmount(amount));

    return this;
  }

  /**
   * @param status the status to add.
   * @return the builder for fluent population of fields.
   */
  public OrderEntityBuilder status(final boolean status) {

    this.parameterToBeApplied.add(target -> target.setStatus(status));

    return this;
  }

  /**
   * @param orderTime the orderTime to add.
   * @return the builder for fluent population of fields.
   */
  public OrderEntityBuilder orderTime(final LocalDateTime orderTime) {

    this.parameterToBeApplied.add(target -> target.setOrderTime(orderTime));

    return this;
  }

  /**
   * @param paymentId the paymentId to add.
   * @return the builder for fluent population of fields.
   */
  public OrderEntityBuilder paymentId(final Long paymentId) {

    this.parameterToBeApplied.add(target -> target.setPaymentId(paymentId));

    return this;
  }

  /**
   * @return the populated OrderEntity.
   */
  public OrderEntity createNew() {

    OrderEntity orderentity = new OrderEntity();
    for (Consumer<OrderEntity> parameter : this.parameterToBeApplied) {
      parameter.accept(orderentity);
    }
    return orderentity;
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
   * @return the OrderEntity
   */
  public OrderEntity persist(EntityManager em) {

    OrderEntity orderentity = createNew();
    em.persist(orderentity);
    return orderentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of OrderEntity
   */
  public List<OrderEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<OrderEntity> orderentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      OrderEntity orderentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(orderentity);
      orderentityList.add(orderentity);
    }

    return orderentityList;
  }

}
