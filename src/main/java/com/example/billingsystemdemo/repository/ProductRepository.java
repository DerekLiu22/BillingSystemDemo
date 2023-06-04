package com.example.billingsystemdemo.repository;

import com.example.billingsystemdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(
            value = "SELECT * " +
                    "FROM product " +
                    "WHERE inventory = 0 " +
                    "ORDER BY inventory ASC",
            nativeQuery = true
    )
    List<Product> getProductWithNoInvent();
}
