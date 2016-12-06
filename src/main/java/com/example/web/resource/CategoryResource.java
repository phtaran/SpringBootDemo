package com.example.web.resource;

import com.example.domain.enumeration.Category;
import com.example.service.CategoryService;
import com.example.web.dto.CategoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/categories")
@Transactional
public class CategoryResource {

    private static Logger LOGGER = LoggerFactory.getLogger(CategoryResource.class);

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    List<String> getCategories() {
        return Stream.of(Category.values()).map(Category::toString).collect(Collectors.toList());
    }

    @PostMapping("/")
    ResponseEntity<CategoryDTO> addCategory(CategoryDTO categoryDTO) {
        LOGGER.debug("CategoryResource::addCategory", categoryDTO);
        return ResponseEntity.ok(categoryDTO);
    }
}
