package com.example.web.resource;

import com.example.domain.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/category")
public class CategoryResource {

    @RequestMapping("/all")
    List<String> getCategories() {
        return Stream.of(Category.values()).map(Category::toString).collect(Collectors.toList());
    }
}
