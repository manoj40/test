package com.carrefour.shopping.cartmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.cartmanagement.logic.api.Cartmanagement;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartCto;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartEto;
import com.carrefour.shopping.cartmanagement.logic.api.to.CartSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Cartmanagement}.
 */
@Path("/cartmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CartmanagementRestService {

  /**
   * Delegates to {@link Cartmanagement#findCart}.
   *
   * @param id the ID of the {@link CartEto}
   * @return the {@link CartEto}
   */
  @GET
  @Path("/cart/{id}/")
  public CartEto getCart(@PathParam("id") long id);

  /**
   * Delegates to {@link Cartmanagement#saveCart}.
   *
   * @param cart the {@link CartEto} to be saved
   * @return the recently created {@link CartEto}
   */
  @POST
  @Path("/cart/")
  public CartEto saveCart(CartEto cart);

  /**
   * Delegates to {@link Cartmanagement#deleteCart}.
   *
   * @param id ID of the {@link CartEto} to be deleted
   */
  @DELETE
  @Path("/cart/{id}/")
  public void deleteCart(@PathParam("id") long id);

  /**
   * Delegates to {@link Cartmanagement#findCartEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding carts.
   * @return the {@link Page list} of matching {@link CartEto}s.
   */
  @Path("/cart/search")
  @POST
  public Page<CartEto> findCarts(CartSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Cartmanagement#findCartCto}.
   *
   * @param id the ID of the {@link CartCto}
   * @return the {@link CartCto}
   */
  @GET
  @Path("/cart/cto/{id}/")
  public CartCto getCartCto(@PathParam("id") long id);

  /**
   * Delegates to {@link Cartmanagement#findCartCtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding carts.
   * @return the {@link Page list} of matching {@link CartCto}s.
   */
  @Path("/cart/cto/search")
  @POST
  public Page<CartCto> findCartCtos(CartSearchCriteriaTo searchCriteriaTo);

}
