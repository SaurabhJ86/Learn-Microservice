package com.jhingan.productservice.repository;


import com.jhingan.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepostoryInterface extends MongoRepository<Product, Integer> {
}
