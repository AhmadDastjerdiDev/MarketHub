package com.example.markethub1.product.service;

import com.example.markethub1.customer.entity.Customer;
import com.example.markethub1.customer.exceptions.CustomerAlreadyExistsException;
import com.example.markethub1.product.dto.ProductDTO;
import com.example.markethub1.product.entity.Product;
import com.example.markethub1.product.exceptions.NoSuchProductExistsException;
import com.example.markethub1.product.exceptions.ProductAlreadyExistsException;
import com.example.markethub1.product.repository.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    @Override
    public void saveProduct(ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepo.findById(productDTO.getProductId());
        if (optionalProduct.isPresent())
            throw new ProductAlreadyExistsException("This Product Already Exixts!");
        else
            productRepo.save(modelMapper.map(productDTO, Product.class));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepo.findAll().stream().map(product -> modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isPresent()) {
            return modelMapper.map(optionalProduct.get(), ProductDTO.class);
        } else
            throw new NoSuchProductExistsException("No Such Product Exists By this Id!");
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isPresent()) {
            Product updatingProduct = optionalProduct.get();
            extractProperties(productDTO, updatingProduct);
            productRepo.save(updatingProduct);
            return modelMapper.map(updatingProduct, ProductDTO.class);
        } else
            throw new NoSuchProductExistsException("No Such Product Exists For Update!");
    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isPresent()) {
            Product deletingProduct = optionalProduct.get();
            productRepo.delete(deletingProduct);
        } else
            throw new NoSuchProductExistsException("No Such Product Exists For Delete!");
    }

    public void extractProperties(ProductDTO productDTO, Product product){
        product.setProductName(productDTO.getProductName());
        product.setProductType(productDTO.getProductType());
        product.setPrice(productDTO.getPrice());
    }
}
