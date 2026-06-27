package com.ecomm.product_service.controller;

import com.ecomm.product_service.dto.ProductRequest;
import com.ecomm.product_service.entity.Product;
import com.ecomm.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody ProductRequest request) {
        return new ResponseEntity<>(service.createProduct(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getProducts(),HttpStatus.OK);
    }

    @GetMapping("/availablePrice")
    public ResponseEntity<List<Product>> getPriceAvailableProducts() {
        return ResponseEntity.ok(service.availablePriceProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        if (service.getProductById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateByProductId(@PathVariable Long id, @RequestBody ProductRequest request) {
        service.updateByProductId(id, request);
        return new ResponseEntity<>("Product Updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductbyId(@PathVariable Long id) {
        service.deleteByProductId(id);
        return ResponseEntity.noContent().build();
    }
}
