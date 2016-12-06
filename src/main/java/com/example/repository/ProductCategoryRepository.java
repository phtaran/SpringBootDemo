package com.example.repository;

import com.example.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for ProductCategory
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
