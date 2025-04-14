package com.example.markethub1.Product.service;

import com.example.markethub1.Product.dto.ProductDTO;
import com.example.markethub1.order.dto.OrderDTO;

import java.util.List;

public interface ProductService {
    public void saveProduct(ProductDTO productDTO);
    public List<ProductDTO> getAllProducts();
    public ProductDTO getProductById(Long productId);
    public void updateProduct(Long productId, ProductDTO productDTO);
    public void deleteProduct(Long productId);
}
