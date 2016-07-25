package util.mockbuilders;

import com.sky.dataaccess.Product;

public class DataAccessProductBuilder
{
    private Integer id;

    private String category;

    private String productName;

    private String locationId;

    public static DataAccessProductBuilder aProduct()
    {
        return new DataAccessProductBuilder();
    }

    public DataAccessProductBuilder withId(Integer id)
    {
        this.id = id;
        return this;
    }

    public DataAccessProductBuilder withCategory(String category)
    {
        this.category = category;
        return this;
    }

    public DataAccessProductBuilder withProductName(String productName)
    {
        this.productName = productName;
        return this;
    }

    public DataAccessProductBuilder withLocationId(String locationId)
    {
        this.locationId = locationId;
        return this;
    }

    public Product build()
    {
        Product product = new Product();
        product.setId(id);
        product.setCategory(category);
        product.setProductName(productName);
        product.setLocationId(locationId);
        return product;
    }
}
