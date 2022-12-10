package com.dltech.service;


import com.dltech.dtos.TipoOperacionDTO;

import java.util.List;

public interface TipoOperacionService {
    List<TipoOperacionDTO> listarTipoOperacions();

    TipoOperacionDTO obtenerTipoOperacionPorID(long id);

    String eliminarTipoOperacion(long id);
}
