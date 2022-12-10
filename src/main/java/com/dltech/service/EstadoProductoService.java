package com.dltech.service;


import com.dltech.dtos.EstadoProductoDTO;

import java.util.List;

public interface EstadoProductoService {
    List<EstadoProductoDTO> listarEstadoProductos();

    EstadoProductoDTO obtenerEstadoProductoPorID(long id);

    String eliminarEstadoProducto(long id);
}
