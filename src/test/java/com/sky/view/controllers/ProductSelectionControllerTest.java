package com.sky.view.controllers;

import com.sky.domain.model.Category;
import com.sky.domain.model.CustomerId;
import com.sky.domain.model.LocationId;
import com.sky.domain.model.Product;
import com.sky.services.ICatalogueService;
import com.sky.services.ICustomerLocationService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductSelectionControllerTest
{
    @Mock
    private ICatalogueService catalogueService;

    @Mock
    private ICustomerLocationService customerLocationService;

    @InjectMocks
    private ProductSelectionController productSelectionController;

    private MockMvc mockMvc;

    @BeforeTest
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productSelectionController).build();
    }

    @Test
    public void initFormTest() throws Exception {

        when(customerLocationService.getLocationIdForCustomerId(any(CustomerId.class)))
                .thenReturn(LocationId.valueOf("LONDON"));

        List<Product> products = new ArrayList<>();
        Product product = new Product(1, "Sports", "Arsenal TV", "LONDON");
        products.add(product);

        when(catalogueService.getProductsByCategoryAndLocationId(any(Category.class), any(LocationId.class)))
                .thenReturn(products);

        this.mockMvc.perform(get("/selectProduct"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("productSelectorForm"))
                .andExpect(model().attributeExists("sportChannels"))
                .andExpect(model().attributeExists("newsChannels"))
                .andExpect(forwardedUrl("productselection"));

    }

    @Test
    public void submitFormTest() throws Exception
    {
        this.mockMvc.perform(post("/selectProduct"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("selectedSportChannels"))
                .andExpect(model().attributeExists("selectedNewsChannels"))
                .andExpect(model().attributeExists("customerId"))
                .andExpect(forwardedUrl("confirmation"));
    }
}
