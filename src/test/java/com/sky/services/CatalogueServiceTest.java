package com.sky.services;

import com.sky.dataaccess.IProductSelector;
import com.sky.domain.model.Category;
import com.sky.domain.model.LocationId;
import com.sky.domain.model.Product;
import com.sky.services.mappers.IProductMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.mockbuilders.DataAccessProductBuilder;
import util.mockbuilders.DomainProductBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@Test(groups = {"unit"})
public class CatalogueServiceTest
{
    private List<com.sky.dataaccess.Product> dataaccessProducts;
    private List<Product> actualDomainProducts;
    private List<Product> expectedDomainProducts;
    private com.sky.dataaccess.Product dataaccessProduct;
    private Product actualDomainProduct;
    private Product expectedDomainProduct;
    private Category category;
    private LocationId locationId;
    private Integer productId;

    @Mock
    private IProductSelector productSelector;

    @Mock
    private IProductMapper productMapper;

    @InjectMocks
    private CatalogueService catalogueService;

    @BeforeTest
    public void setup()
    {
        actualDomainProducts = null;
        expectedDomainProducts = null;
        dataaccessProduct = null;
        actualDomainProduct = null;
        expectedDomainProduct = null;
        category = null;
        locationId = null;
        productId = null;

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProductsByCategoryAndLocationIdTest()
    {
        givenCategory("Sports");
        givenLocationId("LONDON");
        givenExpectedDomainProducts();
        givenDataaccessProducts();
        givenResultForProductSelectorWhenFindByLocationIdAndCategoryCalled();
        givenResultForProductMapperWithList();

        whenGetProductsByCategoryAndLocationIdCalled();

        thenProperDomainProductsShouldBeReturned();
    }

    @Test
    public void getProductByIdTest()
    {
        givenProductId(1);
        givenExpectedDomainProduct();
        givenResultForProductSelectorWhenFindByIdCalled();
        givenResultForProductMapper();

        whenGetProductByIdCalled();

        thenProperDomainProductShouldBeReturned();
    }

    private void givenExpectedDomainProducts()
    {
        Product p1 = DomainProductBuilder.aProduct().withId(1).withCategory("Sports")
                .withProductName("Arsenal TV").withLocationId("LONDON").build();

        Product p2 = DomainProductBuilder.aProduct().withId(2).withCategory("Sports")
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

    private void givenCategory(String category)
    {
        this.category = Category.valueOf(category);
    }

    private void givenLocationId(String locationId)
    {
        this.locationId = LocationId.valueOf(locationId);
    }

    private void givenProductId(Integer productId)
    {
        this.productId = productId;
    }

    private void givenResultForProductSelectorWhenFindByLocationIdAndCategoryCalled()
    {
        when(productSelector.findByLocationIdAndCategory(locationId, category))
                .thenReturn(dataaccessProducts);
    }

    private void givenResultForProductMapperWithList()
    {
        when(productMapper.map(dataaccessProducts))
                .thenReturn(expectedDomainProducts);
    }

    private void givenResultForProductSelectorWhenFindByIdCalled()
    {
        when(productSelector.findById(productId))
                .thenReturn(dataaccessProduct);
    }

    private void givenResultForProductMapper()
    {
        when(productMapper.map(dataaccessProduct))
                .thenReturn(expectedDomainProduct);
    }

    private void givenDataaccessProducts()
    {
        com.sky.dataaccess.Product p1 = getDataAccessProduct(1, "Sports", "Arsenal TV", "LONDON");

        com.sky.dataaccess.Product p2 = getDataAccessProduct(2, "Sports", "Chelsea TV", "LONDON");

        this.dataaccessProducts = new ArrayList<>();
        dataaccessProducts.add(p1);
        dataaccessProducts.add(p2);
    }

    private com.sky.dataaccess.Product getDataAccessProduct(Integer id, String category, String name, String locationId)
    {
        return DataAccessProductBuilder.aProduct().withId(id).withCategory(category).withProductName(name)
                .withLocationId(locationId).build();
    }

    private void whenGetProductsByCategoryAndLocationIdCalled()
    {
        this.actualDomainProducts = catalogueService.getProductsByCategoryAndLocationId(category, locationId);
    }

    private void thenProperDomainProductsShouldBeReturned()
    {
        Assert.assertEquals(actualDomainProducts, expectedDomainProducts);
    }

    private void whenGetProductByIdCalled()
    {
        this.actualDomainProduct = catalogueService.getProductById(productId);
    }

    private void thenProperDomainProductShouldBeReturned()
    {
        Assert.assertEquals(actualDomainProduct, expectedDomainProduct);
    }
}
