package com.carrefour.shopping.cardmanagement.logic.api.usecase;

import com.carrefour.shopping.cardmanagement.logic.api.to.CardEto;

/**
 * Interface of UcManageCard to centralize documentation and signatures of methods.
 */
public interface UcManageCard {

  /**
   * Deletes a card from the database by its id 'cardId'.
   *
   * @param cardId Id of the card to delete
   * @return boolean <code>true</code> if the card can be deleted, <code>false</code> otherwise
   */
  boolean deleteCard(long cardId);

  /**
   * Saves a card and store it in the database.
   *
   * @param card the {@link CardEto} to create.
   * @return the new {@link CardEto} that has been saved with ID and version.
   */
  CardEto saveCard(CardEto card);

}
