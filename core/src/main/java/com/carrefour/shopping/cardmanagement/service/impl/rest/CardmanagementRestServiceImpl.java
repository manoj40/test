package com.carrefour.shopping.cardmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.cardmanagement.logic.api.Cardmanagement;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardCto;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardEto;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardSearchCriteriaTo;
import com.carrefour.shopping.cardmanagement.service.api.rest.CardmanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Cardmanagement}.
 */
@Named("CardmanagementRestService")
public class CardmanagementRestServiceImpl implements CardmanagementRestService {

  @Inject
  private Cardmanagement cardmanagement;

  @Override
  public CardEto getCard(long id) {

    return this.cardmanagement.findCard(id);
  }

  @Override
  public CardEto saveCard(CardEto card) {

    return this.cardmanagement.saveCard(card);
  }

  @Override
  public void deleteCard(long id) {

    this.cardmanagement.deleteCard(id);
  }

  @Override
  public Page<CardEto> findCards(CardSearchCriteriaTo searchCriteriaTo) {

    return this.cardmanagement.findCards(searchCriteriaTo);
  }

  @Override
  public CardCto getCardCto(long id) {

    return this.cardmanagement.findCardCto(id);
  }

  @Override
  public Page<CardCto> findCardCtos(CardSearchCriteriaTo searchCriteriaTo) {

    return this.cardmanagement.findCardCtos(searchCriteriaTo);
  }

}
