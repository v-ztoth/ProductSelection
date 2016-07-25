package com.sky.services;

import com.sky.domain.model.Category;
import com.sky.domain.model.CustomerId;
import com.sky.domain.model.LocationId;
import com.sky.domain.model.Product;

import java.util.List;

public interface ICatalogueService
{
    List<Product> getProductsByCategoryAndLocationId(Category category, LocationId locationId);
    Product getProductById(Integer id);
}
