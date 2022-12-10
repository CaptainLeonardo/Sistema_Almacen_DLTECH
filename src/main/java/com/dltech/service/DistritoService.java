package com.dltech.service;


import com.dltech.dtos.DistritoDTO;

import java.util.List;

public interface DistritoService {
    List<DistritoDTO> listarDistritos();

    DistritoDTO obtenerDistritoPorID(long id);

    String eliminarDistrito(long id);
}
