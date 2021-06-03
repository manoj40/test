package com.carrefour.shopping.cardmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.cardmanagement.logic.api.Cardmanagement;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardCto;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardEto;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardSearchCriteriaTo;
import com.carrefour.shopping.cardmanagement.logic.api.usecase.UcFindCard;
import com.carrefour.shopping.cardmanagement.logic.api.usecase.UcManageCard;
import com.carrefour.shopping.general.logic.base.AbstractComponentFacade;

/**
 * Implementation of component interface of cardmanagement
 */
@Named
public class CardmanagementImpl extends AbstractComponentFacade implements Cardmanagement {

  @Inject
  private UcFindCard ucFindCard;

  @Inject
  private UcManageCard ucManageCard;

  @Override
  public CardEto findCard(long id) {

    return this.ucFindCard.findCard(id);
  }

  @Override
  public Page<CardEto> findCards(CardSearchCriteriaTo criteria) {

    return this.ucFindCard.findCards(criteria);
  }

  @Override
  public CardEto saveCard(CardEto card) {

    return this.ucManageCard.saveCard(card);
  }

  @Override
  public boolean deleteCard(long id) {

    return this.ucManageCard.deleteCard(id);
  }

  @Override
  public CardCto findCardCto(long id) {

    return ucFindCard.findCardCto(id);
  }

  @Override
  public Page<CardCto> findCardCtos(CardSearchCriteriaTo criteria) {

    return ucFindCard.findCardCtos(criteria);
  }

}
