package com.leandro.producto.controller;

import com.leandro.producto.entity.Product;
import com.leandro.producto.service.CustomExcption.CustomException;
import com.leandro.producto.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;



    @GetMapping("/product")
    public List<Product> list() throws CustomException {
        return productService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) throws CustomException {
        Optional<Product> productOptional = productService.porId(id);
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/product")
    public ResponseEntity<?> save(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> edit(@RequestBody Product product, @PathVariable Long id) throws CustomException {
        Optional<Product> optionalProduct = productService.porId(id);
        if(optionalProduct.isPresent()){
            Product productDb = optionalProduct.get();
            productDb.setTitle(product.getTitle());
            productDb.setPrice(product.getPrice());
            productDb.setDescription(product.getDescription());
            productDb.setCategory(product.getCategory());
            productDb.setImage(product.getImage());
            return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productDb));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) throws CustomException {
        Optional<Product> optionalProduct = productService.porId(id);
        if(optionalProduct.isPresent()){
            productService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
