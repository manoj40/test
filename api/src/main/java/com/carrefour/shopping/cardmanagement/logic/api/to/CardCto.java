package com.carrefour.shopping.cardmanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Card
 */
public class CardCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private CardEto card;

  public CardEto getCard() {

    return card;
  }

  public void setCard(CardEto card) {

    this.card = card;
  }

}
