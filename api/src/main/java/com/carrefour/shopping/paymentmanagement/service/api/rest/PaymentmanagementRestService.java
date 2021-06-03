package com.carrefour.shopping.paymentmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.paymentmanagement.logic.api.Paymentmanagement;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentCto;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentEto;
import com.carrefour.shopping.paymentmanagement.logic.api.to.PaymentSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Paymentmanagement}.
 */
@Path("/paymentmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PaymentmanagementRestService {

  /**
   * Delegates to {@link Paymentmanagement#findPayment}.
   *
   * @param id the ID of the {@link PaymentEto}
   * @return the {@link PaymentEto}
   */
  @GET
  @Path("/payment/{id}/")
  public PaymentEto getPayment(@PathParam("id") long id);

  /**
   * Delegates to {@link Paymentmanagement#savePayment}.
   *
   * @param payment the {@link PaymentEto} to be saved
   * @return the recently created {@link PaymentEto}
   */
  @POST
  @Path("/payment/")
  public PaymentEto savePayment(PaymentEto payment);

  /**
   * Delegates to {@link Paymentmanagement#deletePayment}.
   *
   * @param id ID of the {@link PaymentEto} to be deleted
   */
  @DELETE
  @Path("/payment/{id}/")
  public void deletePayment(@PathParam("id") long id);

  /**
   * Delegates to {@link Paymentmanagement#findPaymentEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding payments.
   * @return the {@link Page list} of matching {@link PaymentEto}s.
   */
  @Path("/payment/search")
  @POST
  public Page<PaymentEto> findPayments(PaymentSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Paymentmanagement#findPaymentCto}.
   *
   * @param id the ID of the {@link PaymentCto}
   * @return the {@link PaymentCto}
   */
  @GET
  @Path("/payment/cto/{id}/")
  public PaymentCto getPaymentCto(@PathParam("id") long id);

  /**
   * Delegates to {@link Paymentmanagement#findPaymentCtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding payments.
   * @return the {@link Page list} of matching {@link PaymentCto}s.
   */
  @Path("/payment/cto/search")
  @POST
  public Page<PaymentCto> findPaymentCtos(PaymentSearchCriteriaTo searchCriteriaTo);

}
