package com.carrefour.shopping.cartmanagement.dataaccess.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.carrefour.shopping.cartmanagement.common.api.Cart;
import com.carrefour.shopping.general.dataaccess.api.ApplicationPersistenceEntity;
import com.carrefour.shopping.productmanagement.common.api.to.ProductQuantityEto;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

/**
 * TODO madwived This type ...
 */
@Entity
@Table(name = "Cart")
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class),
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
public class CartEntity extends ApplicationPersistenceEntity implements Cart {

  private String userName;

  private List<ProductQuantityEto> products = new ArrayList<>();

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
   * @return products
   */
  @Type(type = "jsonb")
  @Column(columnDefinition = "jsonb")
  public List<ProductQuantityEto> getProducts() {

    return this.products;
  }

  /**
   * @param products new value of {@link #getproducts}.
   */
  public void setProducts(List<ProductQuantityEto> products) {

    this.products = products;
  }

}
