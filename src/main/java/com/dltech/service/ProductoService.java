package com.dltech.service;

import com.dltech.dtos.ProductoCreateDTO;
import com.dltech.dtos.ProductoDTO;
import com.dltech.dtos.ProductoUpdateDTO;

import java.util.List;

public interface ProductoService {
    List<ProductoDTO> listarProductos();

    ProductoDTO obtenerProductoPorID(long id);

    ProductoDTO registrarProducto(ProductoCreateDTO productoCreateDTO);

    ProductoDTO actualizarProducto(ProductoUpdateDTO productoUpdateDTO);

    String eliminarProducto(long id);
}
