package com.carrefour.shopping.cardmanagement.logic.impl.usecase;

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

import com.carrefour.shopping.cardmanagement.dataaccess.api.CardEntity;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardCto;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardEto;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardSearchCriteriaTo;
import com.carrefour.shopping.cardmanagement.logic.api.usecase.UcFindCard;
import com.carrefour.shopping.cardmanagement.logic.base.usecase.AbstractCardUc;

/**
 * Use case implementation for searching, filtering and getting Cards
 */
@Named
@Validated
@Transactional
public class UcFindCardImpl extends AbstractCardUc implements UcFindCard {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindCardImpl.class);

  @Override
  public CardEto findCard(long id) {

    LOG.debug("Get Card with id {} from database.", id);
    Optional<CardEntity> foundEntity = getCardRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), CardEto.class);
    else
      return null;
  }

  @Override
  public Page<CardEto> findCards(CardSearchCriteriaTo criteria) {

    Page<CardEntity> cards = getCardRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(cards, CardEto.class);
  }

  @Override
  public CardCto findCardCto(long id) {

    LOG.debug("Get CardCto with id {} from database.", id);
    CardEntity entity = getCardRepository().find(id);
    CardCto cto = new CardCto();
    cto.setCard(getBeanMapper().map(entity, CardEto.class));

    return cto;
  }

  @Override
  public Page<CardCto> findCardCtos(CardSearchCriteriaTo criteria) {

    Page<CardEntity> cards = getCardRepository().findByCriteria(criteria);
    List<CardCto> ctos = new ArrayList<>();
    for (CardEntity entity : cards.getContent()) {
      CardCto cto = new CardCto();
      cto.setCard(getBeanMapper().map(entity, CardEto.class));
      ctos.add(cto);
    }
    Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(), criteria.getPageable().getPageSize());

    return new PageImpl<>(ctos, pagResultTo, cards.getTotalElements());
  }

}
