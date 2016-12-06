package com.example.service;

import com.example.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;
}
