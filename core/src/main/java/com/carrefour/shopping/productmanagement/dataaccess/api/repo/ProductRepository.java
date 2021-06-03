package com.carrefour.shopping.productmanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.carrefour.shopping.productmanagement.dataaccess.api.ProductEntity;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link ProductEntity}
 */
public interface ProductRepository extends DefaultRepository<ProductEntity> {

  List<ProductEntity> findByCategory(String type);

  /**
   * @param criteria the {@link ProductSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link ProductEntity} objects that matched the search. If no pageable is set, it
   *         will return a unique page with all the objects that matched the search.
   */
  default Page<ProductEntity> findByCriteria(ProductSearchCriteriaTo criteria) {

    ProductEntity alias = newDslAlias();
    JPAQuery<ProductEntity> query = newDslQuery(alias);

    String name = criteria.getName();
    if (name != null && !name.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
    }
    String category = criteria.getCategory();
    if (category != null && !category.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getCategory()), category, criteria.getCategoryOption());
    }
    Long quantity = criteria.getQuantity();
    if (quantity != null) {
      query.where($(alias.getQuantity()).eq(quantity));
    }
    Double price = criteria.getPrice();
    if (price != null) {
      query.where($(alias.getPrice()).eq(price));
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
  public default void addOrderBy(JPAQuery<ProductEntity> query, ProductEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "name":
            if (next.isAscending()) {
              query.orderBy($(alias.getName()).asc());
            } else {
              query.orderBy($(alias.getName()).desc());
            }
            break;
          case "category":
            if (next.isAscending()) {
              query.orderBy($(alias.getCategory()).asc());
            } else {
              query.orderBy($(alias.getCategory()).desc());
            }
            break;
          case "quantity":
            if (next.isAscending()) {
              query.orderBy($(alias.getQuantity()).asc());
            } else {
              query.orderBy($(alias.getQuantity()).desc());
            }
            break;
          case "price":
            if (next.isAscending()) {
              query.orderBy($(alias.getPrice()).asc());
            } else {
              query.orderBy($(alias.getPrice()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}
