package com.carrefour.shopping.common.api.builders;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import com.carrefour.shopping.usermanagement.dataaccess.api.UserEntity;

/**
 * Test data builder for UserEntity generated with cobigen.
 */
public class UserEntityBuilder {

  private List<Consumer<UserEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public UserEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param userName the userName to add.
   * @return the builder for fluent population of fields.
   */
  public UserEntityBuilder userName(final String userName) {

    this.parameterToBeApplied.add(target -> target.setUserName(userName));

    return this;
  }

  /**
   * @param password the password to add.
   * @return the builder for fluent population of fields.
   */
  public UserEntityBuilder password(final String password) {

    this.parameterToBeApplied.add(target -> target.setPassword(password));

    return this;
  }

  /**
   * @param roles the roles to add.
   * @return the builder for fluent population of fields.
   */
  public UserEntityBuilder roles(final String roles) {

    this.parameterToBeApplied.add(target -> target.setRoles(roles));

    return this;
  }

  /**
   * @return the populated UserEntity.
   */
  public UserEntity createNew() {

    UserEntity userentity = new UserEntity();
    for (Consumer<UserEntity> parameter : this.parameterToBeApplied) {
      parameter.accept(userentity);
    }
    return userentity;
  }

  /**
   * Might be enriched to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

    userName("DefaultString");
  }

  /**
   * @param em the {@link EntityManager}
   * @return the UserEntity
   */
  public UserEntity persist(EntityManager em) {

    UserEntity userentity = createNew();
    em.persist(userentity);
    return userentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of UserEntity
   */
  public List<UserEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<UserEntity> userentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      UserEntity userentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(userentity);
      userentityList.add(userentity);
    }

    return userentityList;
  }

}
