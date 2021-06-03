package com.carrefour.shopping.general.service.impl.config;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;

import com.devonfw.module.security.common.api.accesscontrol.AccessControl;
import com.devonfw.module.security.common.api.accesscontrol.AccessControlPermission;
import com.devonfw.module.security.common.api.authentication.DefaultAuthentication;
import com.devonfw.module.security.jwt.common.api.JwtAuthenticator;
import com.devonfw.module.security.jwt.common.api.JwtManager;

import io.jsonwebtoken.Claims;

/**
 * TODO madwived This type ...
 *
 */
@Named
@Primary
public class BaseJwtAuthenticatorImpl implements JwtAuthenticator {

  @Inject
  private JwtManager jwtManager;

  @Override
  public Authentication authenticate(String jwt) {

    Claims claims = this.jwtManager.decodeAndVerify(jwt);
    String principal = claims.getSubject();
    String[] roleIds = claims.get(JwtManager.CLAIM_ROLES, String.class).split(",");
    Set<AccessControl> permissions = Arrays.stream(roleIds).map(access -> new AccessControlPermission(access))
        .collect(Collectors.toSet());
    return DefaultAuthentication.ofAccessControls(principal, jwt, permissions, claims);
  }

}
