package com.carrefour.shopping.common.api.builders;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import com.carrefour.shopping.cardmanagement.dataaccess.api.CardEntity;

/**
 * Test data builder for CardEntity generated with cobigen.
 */
public class CardEntityBuilder {

  private List<Consumer<CardEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public CardEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param creditCardNumber the creditCardNumber to add.
   * @return the builder for fluent population of fields.
   */
  public CardEntityBuilder creditCardNumber(final String creditCardNumber) {

    this.parameterToBeApplied.add(target -> target.setCreditCardNumber(creditCardNumber));

    return this;
  }

  /**
   * @param userName the userName to add.
   * @return the builder for fluent population of fields.
   */
  public CardEntityBuilder userName(final String userName) {

    this.parameterToBeApplied.add(target -> target.setUserName(userName));

    return this;
  }

  /**
   * @param amount the amount to add.
   * @return the builder for fluent population of fields.
   */
  public CardEntityBuilder amount(final Double amount) {

    this.parameterToBeApplied.add(target -> target.setAmount(amount));

    return this;
  }

  /**
   * @param status the status to add.
   * @return the builder for fluent population of fields.
   */
  public CardEntityBuilder status(final String status) {

    this.parameterToBeApplied.add(target -> target.setStatus(status));

    return this;
  }

  /**
   * @return the populated CardEntity.
   */
  public CardEntity createNew() {

    CardEntity cardentity = new CardEntity();
    for (Consumer<CardEntity> parameter : this.parameterToBeApplied) {
      parameter.accept(cardentity);
    }
    return cardentity;
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
   * @return the CardEntity
   */
  public CardEntity persist(EntityManager em) {

    CardEntity cardentity = createNew();
    em.persist(cardentity);
    return cardentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of CardEntity
   */
  public List<CardEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<CardEntity> cardentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      CardEntity cardentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(cardentity);
      cardentityList.add(cardentity);
    }

    return cardentityList;
  }

}
