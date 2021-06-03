package com.carrefour.shopping.common.api.builders;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import com.carrefour.shopping.paymentmanagement.dataaccess.api.PaymentEntity;

/**
 * Test data builder for PaymentEntity generated with cobigen.
 */
public class PaymentEntityBuilder {

  private List<Consumer<PaymentEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public PaymentEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param cardId the cardId to add.
   * @return the builder for fluent population of fields.
   */
  public PaymentEntityBuilder cardId(final Long cardId) {

    this.parameterToBeApplied.add(target -> target.setCardId(cardId));

    return this;
  }

  /**
   * @param userName the userName to add.
   * @return the builder for fluent population of fields.
   */
  public PaymentEntityBuilder userName(final String userName) {

    this.parameterToBeApplied.add(target -> target.setUserName(userName));

    return this;
  }

  /**
   * @param amount the amount to add.
   * @return the builder for fluent population of fields.
   */
  public PaymentEntityBuilder amount(final Double amount) {

    this.parameterToBeApplied.add(target -> target.setAmount(amount));

    return this;
  }

  /**
   * @param paymentStatus the paymentStatus to add.
   * @return the builder for fluent population of fields.
   */
  public PaymentEntityBuilder paymentStatus(final boolean paymentStatus) {

    this.parameterToBeApplied.add(target -> target.setPaymentStatus(paymentStatus));

    return this;
  }

  /**
   * @return the populated PaymentEntity.
   */
  public PaymentEntity createNew() {

    PaymentEntity paymententity = new PaymentEntity();
    for (Consumer<PaymentEntity> parameter : this.parameterToBeApplied) {
      parameter.accept(paymententity);
    }
    return paymententity;
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
   * @return the PaymentEntity
   */
  public PaymentEntity persist(EntityManager em) {

    PaymentEntity paymententity = createNew();
    em.persist(paymententity);
    return paymententity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of PaymentEntity
   */
  public List<PaymentEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<PaymentEntity> paymententityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      PaymentEntity paymententity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(paymententity);
      paymententityList.add(paymententity);
    }

    return paymententityList;
  }

}
