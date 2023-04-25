package com.example.ecommerce;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
   ProductRepository ProductRepository;

    @Test
    void testFindByCategoryId() {
        List<Product> products = ProductRepository.findByCategoryId(1L);
        assertEquals(2, products.size());
    }
}
