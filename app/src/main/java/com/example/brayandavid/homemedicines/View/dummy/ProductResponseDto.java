package com.example.brayandavid.homemedicines.View.dummy;

import com.example.brayandavid.homemedicines.Objects.Product;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Kevin Ortiz on 14/03/2018.
 */

public class ProductResponseDto implements Serializable {

    private  List<Product> productos;

    public List<Product> getProductos() {
        return productos;
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }
}
