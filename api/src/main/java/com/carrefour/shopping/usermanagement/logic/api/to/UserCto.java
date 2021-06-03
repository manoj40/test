package com.carrefour.shopping.usermanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of User
 */
public class UserCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private UserEto user;

  public UserEto getUser() {

    return user;
  }

  public void setUser(UserEto user) {

    this.user = user;
  }

}
