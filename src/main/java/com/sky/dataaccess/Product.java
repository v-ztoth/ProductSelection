package com.sky.dataaccess;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@NamedQuery(
        name="Product.findByLocationIdAndCategory",
        query="SELECT p FROM Product p WHERE (p.locationId = :locationId OR p.locationId IS NULL) AND p.category = :category"
)
public class Product
{
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "LOCATION_ID")
    private String locationId;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getLocationId()
    {
        return locationId;
    }

    public void setLocationId(String locationId)
    {
        this.locationId = locationId;
    }
}
