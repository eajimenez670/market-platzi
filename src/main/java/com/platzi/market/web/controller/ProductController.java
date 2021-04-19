package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    @ApiOperation("Get all products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getByCategory/{id}")
    @ApiOperation("Get products by category")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product with category not found")
    })
    public ResponseEntity<List<Product>> getByCategory(@ApiParam(value = "id of category", required = true, example = "2") @PathVariable("id") int idCategory) {
        return productService.getByCategory(idCategory)
                .map(products -> new ResponseEntity<List<Product>>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getScarseProducts/{amount}")
    public ResponseEntity<List<Product>> getScarseProducts(@PathVariable("amount") int amount) {
        return productService.getScarseProducts(amount)
                .map(products -> new ResponseEntity<List<Product>>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int idProduct) {
        return productService.getProduct(idProduct)
                .map(product -> new ResponseEntity<Product>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<Product>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int idProduct) {
        return new ResponseEntity<Boolean>(productService.delete(idProduct), HttpStatus.OK);
    }
}
