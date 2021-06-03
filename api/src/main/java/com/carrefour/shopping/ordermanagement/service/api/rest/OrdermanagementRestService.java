package com.carrefour.shopping.ordermanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.ordermanagement.logic.api.Ordermanagement;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderCto;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderEto;
import com.carrefour.shopping.ordermanagement.logic.api.to.OrderSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Ordermanagement}.
 */
@Path("/ordermanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface OrdermanagementRestService {

  /**
   * Delegates to {@link Ordermanagement#findOrder}.
   *
   * @param id the ID of the {@link OrderEto}
   * @return the {@link OrderEto}
   */
  @GET
  @Path("/order/{id}/")
  public OrderEto getOrder(@PathParam("id") long id);

  /**
   * Delegates to {@link Ordermanagement#saveOrder}.
   *
   * @param order the {@link OrderEto} to be saved
   * @return the recently created {@link OrderEto}
   */
  @POST
  @Path("/order/")
  public OrderEto saveOrder(OrderEto order);

  /**
   * Delegates to {@link Ordermanagement#deleteOrder}.
   *
   * @param id ID of the {@link OrderEto} to be deleted
   */
  @DELETE
  @Path("/order/{id}/")
  public void deleteOrder(@PathParam("id") long id);

  /**
   * Delegates to {@link Ordermanagement#findOrderEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding orders.
   * @return the {@link Page list} of matching {@link OrderEto}s.
   */
  @Path("/order/search")
  @POST
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Ordermanagement#findOrderCto}.
   *
   * @param id the ID of the {@link OrderCto}
   * @return the {@link OrderCto}
   */
  @GET
  @Path("/order/cto/{id}/")
  public OrderCto getOrderCto(@PathParam("id") long id);

  /**
   * Delegates to {@link Ordermanagement#findOrderCtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding orders.
   * @return the {@link Page list} of matching {@link OrderCto}s.
   */
  @Path("/order/cto/search")
  @POST
  public Page<OrderCto> findOrderCtos(OrderSearchCriteriaTo searchCriteriaTo);

}
