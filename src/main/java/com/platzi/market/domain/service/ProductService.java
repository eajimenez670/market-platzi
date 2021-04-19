package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<List<Product>> getByCategory(int idCategory) {
        return productRepository.getByCategory(idCategory);
    }

    public Optional<List<Product>> getScarseProducts(int amount) {
        return productRepository.getScarseProducts(amount);
    }

    public Optional<Product> getProduct(int idProduct) {
        return productRepository.getProduct(idProduct);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int idProduct) {
        return getProduct(idProduct).map(product -> {
            productRepository.delete(idProduct);
            return true;
        }).orElse(false);
    }

}
