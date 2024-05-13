package com.leandro.producto.service;

import com.leandro.producto.entity.Product;
import com.leandro.producto.model.MProduct;
import com.leandro.producto.repository.ProductRepository;
import com.leandro.producto.service.CustomExcption.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;



    @Override
    @Transactional(readOnly = true)
    public List<Product> list() throws CustomException {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new CustomException("Error al recuperar la lista de productos", e);

        }
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Product> porId(Long id) throws CustomException {
        try {
            return productRepository.findById(id);
        } catch (Exception e) {
            throw new CustomException("Error al recuperar el productos", e);

        }
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
