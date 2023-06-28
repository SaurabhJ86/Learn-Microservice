package com.jhingan.productservice.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.jhingan.productservice.model.Product;
import com.jhingan.productservice.repository.ProductRepostoryInterface;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;

//@ChangeUnit(id="client-start", order = "1", author = "saurabh")
@ChangeLog
public class DatabaseChangeLog {
//    private final MongoTemplate mongoTemplate;

//    @Autowired
//    public DatabaseChangeLog(MongoTemplate mongoTemplate)
//    {
//        this.mongoTemplate = mongoTemplate;
//    }

    @ChangeSet(order = "001", id = "seedDatabase", author = "Saurabh")
    public void seedDatabase(ProductRepostoryInterface productRepostoryInterface)
    {
        Product product = createNewProduct("Iphone", "Iphone 14", 100000);
        productRepostoryInterface.save(product);
    }

    private Product createNewProduct(String name, String description, Integer price)
    {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        return product;
    }

}
