package com.jhingan.productservice.controller;

import com.jhingan.productservice.dto.ProductDTO;
import com.jhingan.productservice.model.Product;
import com.jhingan.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts()
    {
        return this.productService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveProduct(@RequestBody ProductDTO product)
    {
        this.productService.createProduct(product);
        return "Product was created successfully";
    }
}
