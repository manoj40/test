package com.carrefour.shopping.usermanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.carrefour.shopping.usermanagement.dataaccess.api.UserEntity;
import com.carrefour.shopping.usermanagement.logic.api.to.UserEto;
import com.carrefour.shopping.usermanagement.logic.api.to.UserSearchCriteriaTo;
import com.carrefour.shopping.usermanagement.logic.api.usecase.UcFindUser;
import com.carrefour.shopping.usermanagement.logic.base.usecase.AbstractUserUc;

/**
 * Use case implementation for searching, filtering and getting Users
 */
@Named
@Validated
@Transactional
public class UcFindUserImpl extends AbstractUserUc implements UcFindUser {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindUserImpl.class);

  @Override
  public UserEto findUser(long id) {

    LOG.debug("Get User with id {} from database.", id);
    Optional<UserEntity> foundEntity = getUserRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), UserEto.class);
    else
      return null;
  }

  @Override
  public Page<UserEto> findUsers(UserSearchCriteriaTo criteria) {

    Page<UserEntity> users = getUserRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(users, UserEto.class);
  }

  /*
   * @Override public UserCto findUserCto(long id) {
   *
   * LOG.debug("Get UserCto with id {} from database.", id); UserEntity entity = getUserRepository().find(id); UserCto
   * cto = new UserCto(); cto.setUser(getBeanMapper().map(entity, UserEto.class));
   *
   * return cto; }
   *
   * @Override public Page<UserCto> findUserCtos(UserSearchCriteriaTo criteria) {
   *
   * Page<UserEntity> users = getUserRepository().findByCriteria(criteria); List<UserCto> ctos = new ArrayList<>(); for
   * (UserEntity entity : users.getContent()) { UserCto cto = new UserCto(); cto.setUser(getBeanMapper().map(entity,
   * UserEto.class)); ctos.add(cto); } Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(),
   * criteria.getPageable().getPageSize());
   *
   * return new PageImpl<>(ctos, pagResultTo, users.getTotalElements()); }
   */
}
