package com.sky.services.mappers;

import com.sky.dataaccess.Product;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.mockbuilders.DataAccessProductBuilder;
import util.mockbuilders.DomainProductBuilder;

import java.util.ArrayList;
import java.util.List;

@Test(groups = {"unit"})
public class ProductMapperTest
{
    private IProductMapper productMapper;
    private List<Product> dataaccessProducts;
    private List<com.sky.domain.model.Product> actualDomainProducts;
    private List<com.sky.domain.model.Product> expectedDomainProducts;
    private Product dataaccessProduct;
    private com.sky.domain.model.Product actualDomainProduct;
    private com.sky.domain.model.Product expectedDomainProduct;

    @BeforeTest
    private void init()
    {
        productMapper = null;
        dataaccessProducts = null;
        actualDomainProducts = null;
        expectedDomainProducts = null;
        dataaccessProduct = null;
        actualDomainProduct = null;
        expectedDomainProduct = null;
    }

    @Test
    public void mapTestWithList()
    {
        givenAProductMapper();
        givenDataaccessProducts();
        givenExpectedDomainProducts();
        whenMapCalledWithList();
        thenDomainProductsShouldBeMapped();
    }

    @Test
    public void mapTest()
    {
        givenAProductMapper();
        givenDataaccessProduct();
        givenExpectedDomainProduct();
        whenMapCalled();
        thenDomainProductShouldBeMapped();
    }

    private void givenAProductMapper()
    {
        this.productMapper = new ProductMapper();
    }

    private void givenDataaccessProducts()
    {
        Product p1 = getDataAccessProduct(1, "Sports", "Arsenal TV", "LONDON");

        Product p2 = getDataAccessProduct(2, "Sports", "Chelsea TV", "LONDON");

        this.dataaccessProducts = new ArrayList<>();
        dataaccessProducts.add(p1);
        dataaccessProducts.add(p2);
    }

    private Product getDataAccessProduct(Integer id, String category, String name, String locationId)
    {
        return DataAccessProductBuilder.aProduct().withId(id).withCategory(category).withProductName(name)
                .withLocationId(locationId).build();
    }

    private void givenDataaccessProduct()
    {
        this.dataaccessProduct = getDataAccessProduct(1, "Sports", "Arsenal TV", "LONDON");
    }

    private void givenExpectedDomainProducts()
    {
        com.sky.domain.model.Product p1 = DomainProductBuilder.aProduct().withId(1).withCategory("Sports")
                .withProductName("Arsenal TV").withLocationId("LONDON").build();

        com.sky.domain.model.Product p2 = DomainProductBuilder.aProduct().withId(2).withCategory("Sports")
                .withProductName("Chelsea TV").withLocationId("LONDON").build();

        this.expectedDomainProducts = new ArrayList<>();
        expectedDomainProducts.add(p1);
        expectedDomainProducts.add(p2);
    }

    private void givenExpectedDomainProduct()
    {
        this.expectedDomainProduct = DomainProductBuilder.aProduct().withId(1).withCategory("Sports")
                .withProductName("Arsenal TV").withLocationId("LONDON").build();
    }

    private void whenMapCalledWithList()
    {
        this.actualDomainProducts = productMapper.map(dataaccessProducts);
    }

    private void whenMapCalled()
    {
        this.actualDomainProduct = productMapper.map(dataaccessProduct);
    }

    private void thenDomainProductsShouldBeMapped()
    {
        Assert.assertEquals(actualDomainProducts, expectedDomainProducts);
    }

    private void thenDomainProductShouldBeMapped()
    {
        Assert.assertEquals(actualDomainProduct, expectedDomainProduct);
    }
}
