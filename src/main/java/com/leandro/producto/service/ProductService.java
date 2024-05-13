package com.leandro.producto.service;

import com.leandro.producto.entity.Product;
import com.leandro.producto.model.MProduct;
import com.leandro.producto.service.CustomExcption.CustomException;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> list() throws CustomException;
    Optional<Product> porId(Long id) throws CustomException;
    Product save(Product product);
    void delete(Long id);
}
