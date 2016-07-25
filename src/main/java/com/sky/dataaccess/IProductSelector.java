package com.sky.dataaccess;

import com.sky.domain.model.Category;
import com.sky.domain.model.LocationId;

import java.util.List;

public interface IProductSelector
{
    List<Product> findByLocationIdAndCategory(LocationId locationId, Category category);
    Product findById(Integer id);
}
