package com.carrefour.shopping.usermanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.carrefour.shopping.usermanagement.dataaccess.api.UserEntity;
import com.carrefour.shopping.usermanagement.logic.api.to.UserSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link UserEntity}
 */
public interface UserRepository extends DefaultRepository<UserEntity> {

  Optional<UserEntity> findByUserName(String userName);

  /**
   * @param criteria the {@link UserSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link UserEntity} objects that matched the search. If no pageable is set, it will
   *         return a unique page with all the objects that matched the search.
   */
  default Page<UserEntity> findByCriteria(UserSearchCriteriaTo criteria) {

    UserEntity alias = newDslAlias();
    JPAQuery<UserEntity> query = newDslQuery(alias);

    String userName = criteria.getUserName();
    if (userName != null && !userName.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getUserName()), userName, criteria.getUserNameOption());
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
  public default void addOrderBy(JPAQuery<UserEntity> query, UserEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "userName":
            if (next.isAscending()) {
              query.orderBy($(alias.getUserName()).asc());
            } else {
              query.orderBy($(alias.getUserName()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}
