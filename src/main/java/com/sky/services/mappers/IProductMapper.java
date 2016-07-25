package com.sky.services.mappers;

import com.sky.domain.model.Product;

import java.util.List;

public interface IProductMapper
{
    List<Product> map(List<com.sky.dataaccess.Product> products);
    Product map(com.sky.dataaccess.Product product);
}
