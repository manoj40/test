package com.carrefour.shopping.cardmanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.cardmanagement.logic.api.to.CardCto;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardEto;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardSearchCriteriaTo;

public interface UcFindCard {

  /**
   * Returns a Card by its id 'id'.
   *
   * @param id The id 'id' of the Card.
   * @return The {@link CardEto} with id 'id'
   */
  CardEto findCard(long id);

  /**
   * Returns a paginated list of Cards matching the search criteria.
   *
   * @param criteria the {@link CardSearchCriteriaTo}.
   * @return the {@link List} of matching {@link CardEto}s.
   */
  Page<CardEto> findCards(CardSearchCriteriaTo criteria);

  /**
   * Returns a composite Card by its id 'id'.
   *
   * @param id The id 'id' of the Card.
   * @return The {@link CardCto} with id 'id'
   */
  CardCto findCardCto(long id);

  /**
   * Returns a paginated list of composite Cards matching the search criteria.
   *
   * @param criteria the {@link CardSearchCriteriaTo}.
   * @return the {@link List} of matching {@link CardCto}s.
   */
  Page<CardCto> findCardCtos(CardSearchCriteriaTo criteria);

}
