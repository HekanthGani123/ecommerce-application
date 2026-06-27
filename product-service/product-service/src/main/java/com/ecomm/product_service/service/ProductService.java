package com.ecomm.product_service.service;

import com.ecomm.product_service.dto.ProductRequest;
import com.ecomm.product_service.entity.Product;
import com.ecomm.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product createProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        repository.save(product);
        return product;
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public List<Product> availablePriceProducts() {
        return repository.findAll()
                .stream()
                .filter(p -> p.getPrice() != null)
                .collect(Collectors.toList());
    }

    public Product getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void updateByProductId(Long id, ProductRequest request) {
        Product product = repository.findById(id).orElse(null);
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        repository.save(product);
    }

    public void deleteByProductId(Long id) {
        repository.deleteById(id);
    }
}
