package com.carrefour.shopping.productmanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.carrefour.shopping.general.dataaccess.api.ApplicationPersistenceEntity;
import com.carrefour.shopping.productmanagement.common.api.Product;

/**
 * TODO madwived This type ...
 */
@Entity
@Table(name = "Product")
public class ProductEntity extends ApplicationPersistenceEntity implements Product {

  @NotNull
  private String name;

  @NotNull
  private String category;

  @NotNull
  private Long quantity;

  @NotNull
  private Double price;

  private static final long serialVersionUID = 1L;

  /**
   * @return name
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return category
   */
  @Override
  public String getCategory() {

    return this.category;
  }

  /**
   * @param category new value of {@link #getcategory}.
   */
  @Override
  public void setCategory(String category) {

    this.category = category;
  }

  /**
   * @return quantity
   */
  @Override
  public Long getQuantity() {

    return this.quantity;
  }

  /**
   * @param quantity new value of {@link #getquantity}.
   */
  @Override
  public void setQuantity(Long quantity) {

    this.quantity = quantity;
  }

  /**
   * @return price
   */
  @Override
  public Double getPrice() {

    return this.price;
  }

  /**
   * @param price new value of {@link #getprice}.
   */
  @Override
  public void setPrice(Double price) {

    this.price = price;
  }
}
