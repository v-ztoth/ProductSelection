package com.sky.domain.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Product
{
    private final Integer id;

    private final String category;

    private final String productName;

    private final String locationId;

    public Product(Integer id, String category, String productName, String locationId) {
        this.id = id;
        this.category = category;
        this.productName = productName;
        this.locationId = locationId;
    }

    public Integer getId()
    {
        return id;
    }

    public String getCategory()
    {
        return category;
    }

    public String getProductName()
    {
        return productName;
    }

    public String getLocationId()
    {
        return locationId;
    }
}
