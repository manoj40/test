package com.carrefour.shopping.cardmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.cardmanagement.logic.api.Cardmanagement;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardCto;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardEto;
import com.carrefour.shopping.cardmanagement.logic.api.to.CardSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Cardmanagement}.
 */
@Path("/cardmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CardmanagementRestService {

  /**
   * Delegates to {@link Cardmanagement#findCard}.
   *
   * @param id the ID of the {@link CardEto}
   * @return the {@link CardEto}
   */
  @GET
  @Path("/card/{id}/")
  public CardEto getCard(@PathParam("id") long id);

  /**
   * Delegates to {@link Cardmanagement#saveCard}.
   *
   * @param card the {@link CardEto} to be saved
   * @return the recently created {@link CardEto}
   */
  @POST
  @Path("/card/")
  public CardEto saveCard(CardEto card);

  /**
   * Delegates to {@link Cardmanagement#deleteCard}.
   *
   * @param id ID of the {@link CardEto} to be deleted
   */
  @DELETE
  @Path("/card/{id}/")
  public void deleteCard(@PathParam("id") long id);

  /**
   * Delegates to {@link Cardmanagement#findCardEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding cards.
   * @return the {@link Page list} of matching {@link CardEto}s.
   */
  @Path("/card/search")
  @POST
  public Page<CardEto> findCards(CardSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Cardmanagement#findCardCto}.
   *
   * @param id the ID of the {@link CardCto}
   * @return the {@link CardCto}
   */
  @GET
  @Path("/card/cto/{id}/")
  public CardCto getCardCto(@PathParam("id") long id);

  /**
   * Delegates to {@link Cardmanagement#findCardCtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding cards.
   * @return the {@link Page list} of matching {@link CardCto}s.
   */
  @Path("/card/cto/search")
  @POST
  public Page<CardCto> findCardCtos(CardSearchCriteriaTo searchCriteriaTo);

}
