package com.carrefour.shopping.cardmanagement.logic.base.usecase;

import javax.inject.Inject;

import com.carrefour.shopping.cardmanagement.dataaccess.api.repo.CardRepository;
import com.carrefour.shopping.general.logic.base.AbstractUc;

/**
 * Abstract use case for Cards, which provides access to the commonly necessary data access objects.
 */
public class AbstractCardUc extends AbstractUc {

  /** @see #getCardRepository() */
  @Inject
  private CardRepository cardRepository;

  /**
   * Returns the field 'cardRepository'.
   * 
   * @return the {@link CardRepository} instance.
   */
  public CardRepository getCardRepository() {

    return this.cardRepository;
  }

}
