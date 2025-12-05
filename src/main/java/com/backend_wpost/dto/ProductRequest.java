package com.backend_wpost.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class ProductRequest {
    @NotBlank(message = "Nombre es obligatorio")
    @Size(max = 100, message = "Nombre máximo 100 caracteres")
    private String name;

    @Size(max = 500, message = "Descripción máximo 500 caracteres")
    private String description;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    private BigDecimal price;

    @NotNull(message = "Tener un stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}