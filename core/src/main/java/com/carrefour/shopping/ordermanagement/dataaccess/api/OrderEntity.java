package com.carrefour.shopping.ordermanagement.dataaccess.api;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.carrefour.shopping.general.dataaccess.api.ApplicationPersistenceEntity;
import com.carrefour.shopping.ordermanagement.common.api.Order;
import com.carrefour.shopping.productmanagement.common.api.to.ProductQuantityEto;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

/**
 * TODO madwived This type ...
 */
@Entity
@Table(name = "Orders")
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class),
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
public class OrderEntity extends ApplicationPersistenceEntity implements Order {

  private String userName;

  private List<ProductQuantityEto> products = new ArrayList<>();

  private Double amount;

  private boolean status;

  private LocalDateTime orderTime;

  private Long paymentId;

  private static final long serialVersionUID = 1L;

  /**
   * @return userName
   */
  @Override
  public String getUserName() {

    return this.userName;
  }

  /**
   * @param userName new value of {@link #getuserName}.
   */
  @Override
  public void setUserName(String userName) {

    this.userName = userName;
  }

  /**
   * @return products
   */
  @Override
  @Type(type = "jsonb")
  @Column(columnDefinition = "jsonb")
  public List<ProductQuantityEto> getProducts() {

    return this.products;
  }

  /**
   * @param products new value of {@link #getproducts}.
   */
  @Override
  public void setProducts(List<ProductQuantityEto> products) {

    this.products = products;
  }

  /**
   * @return amount
   */
  @Override
  public Double getAmount() {

    return this.amount;
  }

  /**
   * @param amount new value of {@link #getamount}.
   */
  @Override
  public void setAmount(Double amount) {

    this.amount = amount;
  }

  /**
   * @return status
   */
  public boolean isStatus() {

    return this.status;
  }

  /**
   * @param status new value of {@link #getstatus}.
   */
  public void setStatus(boolean status) {

    this.status = status;
  }

  /**
   * @return orderTime
   */
  @Override
  public LocalDateTime getOrderTime() {

    return this.orderTime;
  }

  /**
   * @param orderTime new value of {@link #getorderTime}.
   */
  @Override
  public void setOrderTime(LocalDateTime orderTime) {

    this.orderTime = orderTime;
  }

  /**
   * @return paymentId
   */
  public Long getPaymentId() {

    return this.paymentId;
  }

  /**
   * @param paymentId new value of {@link #getpaymentId}.
   */
  public void setPaymentId(Long paymentId) {

    this.paymentId = paymentId;
  }

}
