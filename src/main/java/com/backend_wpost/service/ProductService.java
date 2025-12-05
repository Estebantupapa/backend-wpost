package com.backend_wpost.service;

import com.backend_wpost.dto.ProductRequest;
import com.backend_wpost.dto.ProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(UUID id);
    ProductResponse updateProduct(UUID id, ProductRequest request);
    void deleteProduct(UUID id);
}