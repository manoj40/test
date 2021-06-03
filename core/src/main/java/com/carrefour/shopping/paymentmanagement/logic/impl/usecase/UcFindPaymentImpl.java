package com.carrefour.shopping.paymentmanagement.logic.impl.usecase;

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

import com.carrefour.shopping.paymentmanagement.dataaccess.api.PaymentEntity;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentCto;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentEto;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentSearchCriteriaTo;
import com.carrefour.shopping.paymentmanagement.logic.api.usecase.UcFindPayment;
import com.carrefour.shopping.paymentmanagement.logic.base.usecase.AbstractPaymentUc;

/**
 * Use case implementation for searching, filtering and getting Payments
 */
@Named
@Validated
@Transactional
public class UcFindPaymentImpl extends AbstractPaymentUc implements UcFindPayment {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindPaymentImpl.class);

  @Override
  public PaymentEto findPayment(long id) {

    LOG.debug("Get Payment with id {} from database.", id);
    Optional<PaymentEntity> foundEntity = getPaymentRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), PaymentEto.class);
    else
      return null;
  }

  @Override
  public Page<PaymentEto> findPayments(PaymentSearchCriteriaTo criteria) {

    Page<PaymentEntity> payments = getPaymentRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(payments, PaymentEto.class);
  }

  @Override
  public PaymentCto findPaymentCto(long id) {

    LOG.debug("Get PaymentCto with id {} from database.", id);
    PaymentEntity entity = getPaymentRepository().find(id);
    PaymentCto cto = new PaymentCto();
    cto.setPayment(getBeanMapper().map(entity, PaymentEto.class));

    return cto;
  }

  @Override
  public Page<PaymentCto> findPaymentCtos(PaymentSearchCriteriaTo criteria) {

    Page<PaymentEntity> payments = getPaymentRepository().findByCriteria(criteria);
    List<PaymentCto> ctos = new ArrayList<>();
    for (PaymentEntity entity : payments.getContent()) {
      PaymentCto cto = new PaymentCto();
      cto.setPayment(getBeanMapper().map(entity, PaymentEto.class));
      ctos.add(cto);
    }
    Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(), criteria.getPageable().getPageSize());

    return new PageImpl<>(ctos, pagResultTo, payments.getTotalElements());
  }

}
