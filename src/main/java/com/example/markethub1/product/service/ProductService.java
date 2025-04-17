package com.example.markethub1.product.service;

import com.example.markethub1.product.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    public void saveProduct(ProductDTO productDTO);
    public List<ProductDTO> getAllProducts();
    public ProductDTO getProductById(Long productId);
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO);
    public void deleteProduct(Long productId);
}
