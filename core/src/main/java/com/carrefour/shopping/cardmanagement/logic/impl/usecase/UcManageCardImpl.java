package com.carrefour.shopping.cardmanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.carrefour.shopping.cardmanagement.dataaccess.api.CardEntity;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardEto;
import com.carrefour.shopping.cardmanagement.logic.api.usecase.UcManageCard;
import com.carrefour.shopping.cardmanagement.logic.base.usecase.AbstractCardUc;

/**
 * Use case implementation for modifying and deleting Cards
 */
@Named
@Validated
@Transactional
public class UcManageCardImpl extends AbstractCardUc implements UcManageCard {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageCardImpl.class);

  @Override
  public boolean deleteCard(long cardId) {

    CardEntity card = getCardRepository().find(cardId);
    getCardRepository().delete(card);
    LOG.debug("The card with id '{}' has been deleted.", cardId);
    return true;
  }

  @Override
  public CardEto saveCard(CardEto card) {

    Objects.requireNonNull(card, "card");

    CardEntity cardEntity = getBeanMapper().map(card, CardEntity.class);

    // initialize, validate cardEntity here if necessary
    CardEntity resultEntity = getCardRepository().save(cardEntity);
    LOG.debug("Card with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, CardEto.class);
  }
}
