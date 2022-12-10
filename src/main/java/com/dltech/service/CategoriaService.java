package com.dltech.service;


import com.dltech.dtos.CategoriaDTO;

import java.util.List;

public interface CategoriaService {
    List<CategoriaDTO> listarCategorias();

    CategoriaDTO obtenerCategoriaPorID(long id);

    String eliminarCategoria(long id);
}
