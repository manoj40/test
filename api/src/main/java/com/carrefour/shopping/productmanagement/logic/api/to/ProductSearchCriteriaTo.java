package com.carrefour.shopping.productmanagement.logic.api.to;

import com.carrefour.shopping.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of {@link com.carrefour.shopping.productmanagement.common.api.Product}s.
 */
public class ProductSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String type;

  private Long quantity;

  private Double price;

  private StringSearchConfigTo nameOption;

  private StringSearchConfigTo typeOption;

  private String category;

  private StringSearchConfigTo categoryOption;

  /**
   * @return nameId
   */
  public String getName() {

    return name;
  }

  /**
   * @param name setter for name attribute
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return typeId
   */
  public String getType() {

    return type;
  }

  /**
   * @param type setter for type attribute
   */
  public void setType(String type) {

    this.type = type;
  }

  /**
   * @return quantityId
   */
  public Long getQuantity() {

    return quantity;
  }

  /**
   * @param quantity setter for quantity attribute
   */
  public void setQuantity(Long quantity) {

    this.quantity = quantity;
  }

  /**
   * @return priceId
   */
  public Double getPrice() {

    return price;
  }

  /**
   * @param price setter for price attribute
   */
  public void setPrice(Double price) {

    this.price = price;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getName() name}.
   */
  public StringSearchConfigTo getNameOption() {

    return this.nameOption;
  }

  /**
   * @param nameOption new value of {@link #getNameOption()}.
   */
  public void setNameOption(StringSearchConfigTo nameOption) {

    this.nameOption = nameOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getType() type}.
   */
  public StringSearchConfigTo getTypeOption() {

    return this.typeOption;
  }

  /**
   * @param typeOption new value of {@link #getTypeOption()}.
   */
  public void setTypeOption(StringSearchConfigTo typeOption) {

    this.typeOption = typeOption;
  }

  /**
   * @return categoryId
   */
  public String getCategory() {

    return category;
  }

  /**
   * @param category setter for category attribute
   */
  public void setCategory(String category) {

    this.category = category;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getCategory() category}.
   */
  public StringSearchConfigTo getCategoryOption() {

    return this.categoryOption;
  }

  /**
   * @param categoryOption new value of {@link #getCategoryOption()}.
   */
  public void setCategoryOption(StringSearchConfigTo categoryOption) {

    this.categoryOption = categoryOption;
  }

}
