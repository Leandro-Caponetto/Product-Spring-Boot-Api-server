package com.leandro.producto.converter;

import com.leandro.producto.entity.Product;
import com.leandro.producto.model.MProduct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Convertidor {

    public List<MProduct> convertiLista(List<Product> products){
        List<MProduct> mProducts = new ArrayList<>();
        for (Product product : products){
            mProducts.add(new MProduct(product));
        }
        return mProducts;
    }

}
