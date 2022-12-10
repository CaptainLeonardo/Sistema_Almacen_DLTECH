package com.dltech.dtos;

import com.dltech.model.Categoria;
import com.dltech.model.EstadoProducto;
import com.dltech.model.Marca;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {
    private Long idProducto;
    private String descripcion;
    private String modelo;
    private Categoria categoria;
    private EstadoProducto estadoProducto;
    private Marca marca;
}
