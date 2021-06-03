package com.carrefour.shopping.paymentmanagement.logic.base.usecase;

import javax.inject.Inject;

import com.carrefour.shopping.general.logic.base.AbstractUc;
import com.carrefour.shopping.paymentmanagement.dataaccess.api.repo.PaymentRepository;

/**
 * Abstract use case for Payments, which provides access to the commonly necessary data access objects.
 */
public class AbstractPaymentUc extends AbstractUc {

  /** @see #getPaymentRepository() */
  @Inject
  private PaymentRepository paymentRepository;

  /**
   * Returns the field 'paymentRepository'.
   * 
   * @return the {@link PaymentRepository} instance.
   */
  public PaymentRepository getPaymentRepository() {

    return this.paymentRepository;
  }

}
