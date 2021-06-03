package com.carrefour.shopping.paymentmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.paymentmanagement.logic.api.Paymentmanagement;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentCto;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentEto;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentSearchCriteriaTo;
import com.carrefour.shopping.paymentmanagement.service.api.rest.PaymentmanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Paymentmanagement}.
 */
@Named("PaymentmanagementRestService")
public class PaymentmanagementRestServiceImpl implements PaymentmanagementRestService {

  @Inject
  private Paymentmanagement paymentmanagement;

  @Override
  public PaymentEto getPayment(long id) {

    return this.paymentmanagement.findPayment(id);
  }

  @Override
  public PaymentEto savePayment(PaymentEto payment) {

    return this.paymentmanagement.savePayment(payment);
  }

  @Override
  public void deletePayment(long id) {

    this.paymentmanagement.deletePayment(id);
  }

  @Override
  public Page<PaymentEto> findPayments(PaymentSearchCriteriaTo searchCriteriaTo) {

    return this.paymentmanagement.findPayments(searchCriteriaTo);
  }

  @Override
  public PaymentCto getPaymentCto(long id) {

    return this.paymentmanagement.findPaymentCto(id);
  }

  @Override
  public Page<PaymentCto> findPaymentCtos(PaymentSearchCriteriaTo searchCriteriaTo) {

    return this.paymentmanagement.findPaymentCtos(searchCriteriaTo);
  }

}
