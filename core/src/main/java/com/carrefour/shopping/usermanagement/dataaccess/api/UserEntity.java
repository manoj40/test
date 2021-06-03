package com.carrefour.shopping.usermanagement.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.carrefour.shopping.general.dataaccess.api.ApplicationPersistenceEntity;
import com.carrefour.shopping.usermanagement.common.api.User;

/**
 * TODO madwived This type ...
 */
@Entity
@Table(name = "User")
public class UserEntity extends ApplicationPersistenceEntity implements User {

  @Column(unique = true, nullable = false)
  private String userName;

  private String password;

  private String roles;

  private static final long serialVersionUID = 1L;

  /**
   * @return userName
   */
  public String getUserName() {

    return this.userName;
  }

  /**
   * @param userName new value of {@link #getuserName}.
   */
  public void setUserName(String userName) {

    this.userName = userName;
  }

  /**
   * @return password
   */
  public String getPassword() {

    return this.password;
  }

  /**
   * @param password new value of {@link #getpassword}.
   */
  public void setPassword(String password) {

    this.password = password;
  }

  /**
   * @return roles
   */
  public String getRoles() {

    return this.roles;
  }

  /**
   * @param roles new value of {@link #getroles}.
   */
  public void setRoles(String roles) {

    this.roles = roles;
  }

}
