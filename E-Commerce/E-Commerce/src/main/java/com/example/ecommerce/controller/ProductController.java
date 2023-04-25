package com.example.ecommerce.controller;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "index";
    }

    @GetMapping("/category/{categoryId}")
    public String category(@PathVariable Long categoryId, Model model) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        model.addAttribute("products", products);
        return "category";
    }

    @GetMapping("/price/{price}")
    public String price(@PathVariable double price, Model model) {
        List<Product> products = productRepository.findByPriceLessThan(price);
        model.addAttribute("products", products);
        return "price";
    }
}
