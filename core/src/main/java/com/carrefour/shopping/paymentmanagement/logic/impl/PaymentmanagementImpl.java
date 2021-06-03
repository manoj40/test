package com.carrefour.shopping.paymentmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.general.logic.base.AbstractComponentFacade;
import com.carrefour.shopping.paymentmanagement.logic.api.Paymentmanagement;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentCto;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentEto;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentSearchCriteriaTo;
import com.carrefour.shopping.paymentmanagement.logic.api.usecase.UcFindPayment;
import com.carrefour.shopping.paymentmanagement.logic.api.usecase.UcManagePayment;

/**
 * Implementation of component interface of paymentmanagement
 */
@Named
public class PaymentmanagementImpl extends AbstractComponentFacade implements Paymentmanagement {

  @Inject
  private UcFindPayment ucFindPayment;

  @Inject
  private UcManagePayment ucManagePayment;

  @Override
  public PaymentEto findPayment(long id) {

    return this.ucFindPayment.findPayment(id);
  }

  @Override
  public Page<PaymentEto> findPayments(PaymentSearchCriteriaTo criteria) {

    return this.ucFindPayment.findPayments(criteria);
  }

  @Override
  public PaymentEto savePayment(PaymentEto payment) {

    return this.ucManagePayment.savePayment(payment);
  }

  @Override
  public boolean deletePayment(long id) {

    return this.ucManagePayment.deletePayment(id);
  }

  @Override
  public PaymentCto findPaymentCto(long id) {

    return ucFindPayment.findPaymentCto(id);
  }

  @Override
  public Page<PaymentCto> findPaymentCtos(PaymentSearchCriteriaTo criteria) {

    return ucFindPayment.findPaymentCtos(criteria);
  }

}
