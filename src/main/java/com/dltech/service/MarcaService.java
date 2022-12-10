package com.dltech.service;


import com.dltech.dtos.MarcaDTO;

import java.util.List;

public interface MarcaService {
    List<MarcaDTO> listarMarcas();

    MarcaDTO obtenerMarcaPorID(long id);

    String eliminarMarca(long id);
}
