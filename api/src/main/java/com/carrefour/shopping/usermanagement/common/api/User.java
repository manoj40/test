package com.carrefour.shopping.usermanagement.common.api;

import com.carrefour.shopping.general.common.api.ApplicationEntity;

public interface User extends ApplicationEntity {

  /**
   * @return userNameId
   */

  public String getUserName();

  /**
   * @param userName setter for userName attribute
   */

  public void setUserName(String userName);

  /**
   * @return passwordId
   */

  public String getPassword();

  /**
   * @param password setter for password attribute
   */

  public void setPassword(String password);

}
