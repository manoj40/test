package com.carrefour.shopping.paymentmanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.carrefour.shopping.paymentmanagement.dataaccess.api.PaymentEntity;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentEto;
import com.carrefour.shopping.paymentmanagement.logic.api.usecase.UcManagePayment;
import com.carrefour.shopping.paymentmanagement.logic.base.usecase.AbstractPaymentUc;

/**
 * Use case implementation for modifying and deleting Payments
 */
@Named
@Validated
@Transactional
public class UcManagePaymentImpl extends AbstractPaymentUc implements UcManagePayment {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManagePaymentImpl.class);

  @Override
  public boolean deletePayment(long paymentId) {

    PaymentEntity payment = getPaymentRepository().find(paymentId);
    getPaymentRepository().delete(payment);
    LOG.debug("The payment with id '{}' has been deleted.", paymentId);
    return true;
  }

  @Override
  public PaymentEto savePayment(PaymentEto payment) {

    Objects.requireNonNull(payment, "payment");

    PaymentEntity paymentEntity = getBeanMapper().map(payment, PaymentEntity.class);

    // initialize, validate paymentEntity here if necessary
    PaymentEntity resultEntity = getPaymentRepository().save(paymentEntity);
    LOG.debug("Payment with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, PaymentEto.class);
  }
}
