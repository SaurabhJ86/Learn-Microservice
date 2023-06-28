package com.jhingan.productservice.service;

import com.jhingan.productservice.dto.ProductDTO;
import com.jhingan.productservice.model.Product;
import com.jhingan.productservice.repository.ProductRepostoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepostoryInterface productRepostoryInterface;

    public ProductService(ProductRepostoryInterface productRepostoryInterface)
    {
        this.productRepostoryInterface = productRepostoryInterface;
    }

    public void createProduct(ProductDTO productDTO)
    {
        Product product = Product.builder()
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .name(productDTO.getName())
                .build();
        this.productRepostoryInterface.save(product);
    }

    public List<Product> getAll() {
        return this.productRepostoryInterface.findAll();
    }
}
