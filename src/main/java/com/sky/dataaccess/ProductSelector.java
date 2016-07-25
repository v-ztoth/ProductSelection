package com.sky.dataaccess;

import com.sky.domain.model.Category;
import com.sky.domain.model.LocationId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class ProductSelector implements IProductSelector
{
    private final ProductRepository productRepository;

    @Autowired
    public ProductSelector(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findByLocationIdAndCategory(LocationId locationId, Category category)
    {
        return productRepository.findByLocationIdAndCategory(locationId.getValue() ,category.getValue());
    }

    @Override
    public Product findById(Integer id)
    {
        return productRepository.findOne(id);
    }
}
