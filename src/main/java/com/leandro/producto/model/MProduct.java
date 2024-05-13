package com.leandro.producto.model;

import com.leandro.producto.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class MProduct {

    public MProduct(Product product){
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.image = product.getImage();
    }

    private Long id;
    private String title;
    private Long price;

    @Column
    @Size(max=1050, message = "El tamaño máximo del campo name es 30")
    private String description;
    private String image;
}
