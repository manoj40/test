package com.carrefour.shopping.cardmanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.carrefour.shopping.cardmanagement.dataaccess.api.CardEntity;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link CardEntity}
 */
public interface CardRepository extends DefaultRepository<CardEntity> {

  /**
   * @param criteria the {@link CardSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link CardEntity} objects that matched the search. If no pageable is set, it will
   *         return a unique page with all the objects that matched the search.
   */
  default Page<CardEntity> findByCriteria(CardSearchCriteriaTo criteria) {

    CardEntity alias = newDslAlias();
    JPAQuery<CardEntity> query = newDslQuery(alias);

    String creditCardNumber = criteria.getCreditCardNumber();
    if (creditCardNumber != null && !creditCardNumber.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getCreditCardNumber()), creditCardNumber,
          criteria.getCreditCardNumberOption());
    }
    String userName = criteria.getUserName();
    if (userName != null && !userName.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getUserName()), userName, criteria.getUserNameOption());
    }
    Double amount = criteria.getAmount();
    if (amount != null) {
      query.where($(alias.getAmount()).eq(amount));
    }
    String status = criteria.getStatus();
    if (status != null && !status.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getStatus()), status, criteria.getStatusOption());
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
  public default void addOrderBy(JPAQuery<CardEntity> query, CardEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "creditCardNumber":
            if (next.isAscending()) {
              query.orderBy($(alias.getCreditCardNumber()).asc());
            } else {
              query.orderBy($(alias.getCreditCardNumber()).desc());
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
          case "status":
            if (next.isAscending()) {
              query.orderBy($(alias.getStatus()).asc());
            } else {
              query.orderBy($(alias.getStatus()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}