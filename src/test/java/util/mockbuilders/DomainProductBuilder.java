package util.mockbuilders;

import com.sky.domain.model.Product;

public class DomainProductBuilder
{
    private Integer id;

    private String category;

    private String productName;

    private String locationId;

    public static DomainProductBuilder aProduct()
    {
        return new DomainProductBuilder();
    }

    public DomainProductBuilder withId(Integer id)
    {
        this.id = id;
        return this;
    }

    public DomainProductBuilder withCategory(String category)
    {
        this.category = category;
        return this;
    }

    public DomainProductBuilder withProductName(String productName)
    {
        this.productName = productName;
        return this;
    }

    public DomainProductBuilder withLocationId(String locationId)
    {
        this.locationId = locationId;
        return this;
    }

    public Product build()
    {
        Product product = new Product(id, category, productName, locationId);
        return product;
    }
}
