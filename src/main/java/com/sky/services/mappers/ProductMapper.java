package com.sky.services.mappers;

import com.sky.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProductMapper implements IProductMapper
{
    @Override
    public List<Product> map(List<com.sky.dataaccess.Product> products) {
        return products.stream().filter(Objects::nonNull).map(p -> createDomainProduct(p)).collect(Collectors.toList());
    }

    @Override
    public Product map(com.sky.dataaccess.Product product)
    {
        if(product == null)
        {
            return null;
        }

        return createDomainProduct(product);
    }

    private Product createDomainProduct(com.sky.dataaccess.Product product)
    {
        return new Product(product.getId(), product.getCategory(),
                product.getProductName(), product.getLocationId());
    }
}
