package com.backend_wpost.service.impl;

import com.backend_wpost.dto.ProductRequest;
import com.backend_wpost.dto.ProductResponse;
import com.backend_wpost.entity.product;
import com.backend_wpost.exception.ResourceNotFoundException;
import com.backend_wpost.repository.ProductRepository;
import com.backend_wpost.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        // Crear nuevo producto
        product Product = new product();
        Product.setName(request.getName());
        Product.setDescription(request.getDescription());
        Product.setPrice(request.getPrice());
        Product.setStock(request.getStock());

        // Guardar producto
        product savedProduct = productRepository.save(Product);

        // Convertir a Response
        return mapToResponse(savedProduct);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        // Obtener todos los productos
        List<product> products = productRepository.findAll();

        // Convertir cada producto a Response
        return products.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(UUID id) {
        // Buscar producto por ID
        product Product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));

        // Convertir a Response
        return mapToResponse(Product);
    }

    @Override
    public ProductResponse updateProduct(UUID id, ProductRequest request) {
        // Buscar producto existente
        product Product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));

        // Actualizar campos
        Product.setName(request.getName());
        Product.setDescription(request.getDescription());
        Product.setPrice(request.getPrice());
        Product.setStock(request.getStock());

        // Guardar cambios
        product updatedProduct = productRepository.save(Product);

        // Convertir a Response
        return mapToResponse(updatedProduct);
    }

    @Override
    public void deleteProduct(UUID id) {
        // Verificar que el producto existe
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Producto no encontrado con ID: " + id);
        }

        // Eliminar producto
        productRepository.deleteById(id);
    }

    // Método auxiliar para convertir Product a ProductResponse
    private ProductResponse mapToResponse(product Product) {
        ProductResponse response = new ProductResponse();
        response.setId(Product.getId());
        response.setName(Product.getName());
        response.setDescription(Product.getDescription());
        response.setPrice(Product.getPrice());
        response.setStock(Product.getStock());
        response.setFechaCreacion(Product.getFechaCreacion());
        response.setFechaActualizacion(Product.getFechaActualizacion());

        return response;
    }
}