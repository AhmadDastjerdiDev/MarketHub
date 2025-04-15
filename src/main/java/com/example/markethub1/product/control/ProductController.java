package com.example.markethub1.product.control;

import com.example.markethub1.product.dto.ProductDTO;
import com.example.markethub1.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        ProductDTO productDTO = productService.getProductById(id);
        if(productDTO != null)
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO){
        productService.saveProduct(productDTO);
        return new ResponseEntity<>("Product created successfully!",HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        ProductDTO updatingProduct = productService.updateProduct(id, productDTO);
        if (updatingProduct != null) {
            return new ResponseEntity<>("Product updated successfully!",HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        ProductDTO deletingProductDTO = productService.getProductById(id);
        if (deletingProductDTO != null) {
            productService.deleteProduct(id);
            return new ResponseEntity<>("Product deleted successfully!", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
    }
}
