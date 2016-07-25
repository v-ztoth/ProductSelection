package com.sky.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    List<Product> findByLocationIdAndCategory(@Param("locationId") String locationId,
                                              @Param("category") String category);
}
