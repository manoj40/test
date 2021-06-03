package com.carrefour.shopping.paymentmanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.carrefour.shopping.paymentmanagement.dataaccess.api.PaymentEntity;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link PaymentEntity}
 */
public interface PaymentRepository extends DefaultRepository<PaymentEntity> {

  /**
   * @param criteria the {@link PaymentSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link PaymentEntity} objects that matched the search. If no pageable is set, it
   *         will return a unique page with all the objects that matched the search.
   */
  default Page<PaymentEntity> findByCriteria(PaymentSearchCriteriaTo criteria) {

    PaymentEntity alias = newDslAlias();
    JPAQuery<PaymentEntity> query = newDslQuery(alias);

    Long cardId = criteria.getCardId();
    if (cardId != null) {
      query.where($(alias.getCardId()).eq(cardId));
    }
    String userName = criteria.getUserName();
    if (userName != null && !userName.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getUserName()), userName, criteria.getUserNameOption());
    }
    Double amount = criteria.getAmount();
    if (amount != null) {
      query.where($(alias.getAmount()).eq(amount));
    }
    Boolean paymentStatus = criteria.getPaymentStatus();
    if (paymentStatus != null) {
      query.where($(alias.isPaymentStatus()).eq(paymentStatus));
    }
    if (criteria.getPageable() == null) {
      criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
    } else {
      addOrderBy(query, alias, criteria.getPageable().getSort());
    }

    return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
  }

  /**
   * Add sorting to the given query on the given alias
   * 
   * @param query to add sorting to
   * @param alias to retrieve columns from for sorting
   * @param sort specification of sorting
   */
  public default void addOrderBy(JPAQuery<PaymentEntity> query, PaymentEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "cardId":
            if (next.isAscending()) {
              query.orderBy($(alias.getCardId()).asc());
            } else {
              query.orderBy($(alias.getCardId()).desc());
            }
            break;
          case "userName":
            if (next.isAscending()) {
              query.orderBy($(alias.getUserName()).asc());
            } else {
              query.orderBy($(alias.getUserName()).desc());
            }
            break;
          case "amount":
            if (next.isAscending()) {
              query.orderBy($(alias.getAmount()).asc());
            } else {
              query.orderBy($(alias.getAmount()).desc());
            }
            break;
          case "paymentStatus":
            if (next.isAscending()) {
              query.orderBy($(alias.isPaymentStatus()).asc());
            } else {
              query.orderBy($(alias.isPaymentStatus()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}