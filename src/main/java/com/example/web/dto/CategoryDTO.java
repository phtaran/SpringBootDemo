package com.example.web.dto;

import com.example.domain.enumeration.Category;

public class CategoryDTO {
    final Category category;

    public CategoryDTO(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
