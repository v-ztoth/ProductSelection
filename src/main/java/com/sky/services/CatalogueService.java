package com.sky.services;

import com.sky.dataaccess.IProductSelector;
import com.sky.domain.model.Category;
import com.sky.domain.model.LocationId;
import com.sky.domain.model.Product;
import com.sky.services.mappers.IProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueService implements ICatalogueService
{
    private final IProductSelector productSelector;
    private final IProductMapper productMapper;

    @Autowired
    public CatalogueService(IProductSelector productSelector, IProductMapper productMapper)
    {
        this.productSelector = productSelector;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> getProductsByCategoryAndLocationId(Category category, LocationId locationId)
    {
        List<com.sky.dataaccess.Product> productEntities =
                productSelector.findByLocationIdAndCategory(locationId, category);

        return productMapper.map(productEntities);
    }

    @Override
    public Product getProductById(Integer id)
    {
        return productMapper.map(productSelector.findById(id));
    }
}
