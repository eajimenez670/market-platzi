package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    /**
     * Get all products
     * @return
     */
    List<Product> getAll();

    /**
     * Get products by category
     * @param idCategory
     * @return
     */
    Optional<List<Product>> getByCategory(int idCategory);

    /**
     * get products scarse
     * @param amount
     * @return
     */
    Optional<List<Product>> getScarseProducts(int amount);

    /**
     * get product
     * @param idProduct
     * @return
     */
    Optional<Product> getProduct(int idProduct);

    /**
     * Save product
     * @param product
     * @return
     */
    Product save(Product product);

    /**
     * Delete product
     * @param idProduct
     */
    void delete(int idProduct);
}
