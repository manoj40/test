package com.carrefour.shopping.productmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.carrefour.shopping.productmanagement.logic.api.Productmanagement;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductCto;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductEto;
import com.carrefour.shopping.productmanagement.logic.api.to.ProductSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Productmanagement}.
 */
@Path("/productmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ProductmanagementRestService {

  /**
   * Delegates to {@link Productmanagement#findProduct}.
   *
   * @param id the ID of the {@link ProductEto}
   * @return the {@link ProductEto}
   */
  @GET
  @Path("/product/{id}/")
  public ProductEto getProduct(@PathParam("id") long id);

  /**
   * Delegates to {@link Productmanagement#saveProduct}.
   *
   * @param product the {@link ProductEto} to be saved
   * @return the recently created {@link ProductEto}
   */
  @POST
  @Path("/product/")
  public ProductEto saveProduct(ProductEto product);

  /**
   * Delegates to {@link Productmanagement#deleteProduct}.
   *
   * @param id ID of the {@link ProductEto} to be deleted
   */
  @DELETE
  @Path("/product/{id}/")
  public void deleteProduct(@PathParam("id") long id);

  /**
   * Delegates to {@link Productmanagement#findProductEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding products.
   * @return the {@link Page list} of matching {@link ProductEto}s.
   */
  @Path("/product/search")
  @POST
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Productmanagement#findProductCto}.
   *
   * @param id the ID of the {@link ProductCto}
   * @return the {@link ProductCto}
   */
  @GET
  @Path("/product/cto/{id}/")
  public ProductCto getProductCto(@PathParam("id") long id);

  /**
   * Delegates to {@link Productmanagement#findProductCtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding products.
   * @return the {@link Page list} of matching {@link ProductCto}s.
   */
  @Path("/product/cto/search")
  @POST
  public Page<ProductCto> findProductCtos(ProductSearchCriteriaTo searchCriteriaTo);

}
