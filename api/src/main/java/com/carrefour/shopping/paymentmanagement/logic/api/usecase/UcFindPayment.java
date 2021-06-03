package com.carrefour.shopping.paymentmanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentCto;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentEto;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentSearchCriteriaTo;

public interface UcFindPayment {

  /**
   * Returns a Payment by its id 'id'.
   *
   * @param id The id 'id' of the Payment.
   * @return The {@link PaymentEto} with id 'id'
   */
  PaymentEto findPayment(long id);

  /**
   * Returns a paginated list of Payments matching the search criteria.
   *
   * @param criteria the {@link PaymentSearchCriteriaTo}.
   * @return the {@link List} of matching {@link PaymentEto}s.
   */
  Page<PaymentEto> findPayments(PaymentSearchCriteriaTo criteria);

  /**
   * Returns a composite Payment by its id 'id'.
   *
   * @param id The id 'id' of the Payment.
   * @return The {@link PaymentCto} with id 'id'
   */
  PaymentCto findPaymentCto(long id);

  /**
   * Returns a paginated list of composite Payments matching the search criteria.
   *
   * @param criteria the {@link PaymentSearchCriteriaTo}.
   * @return the {@link List} of matching {@link PaymentCto}s.
   */
  Page<PaymentCto> findPaymentCtos(PaymentSearchCriteriaTo criteria);

}
