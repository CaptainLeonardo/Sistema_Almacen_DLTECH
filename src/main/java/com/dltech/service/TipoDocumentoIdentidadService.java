package com.dltech.service;


import com.dltech.dtos.TipoDocumentoIdentidadDTO;

import java.util.List;

public interface TipoDocumentoIdentidadService {
    List<TipoDocumentoIdentidadDTO> listarTipoDocumentoIdentidads();

    TipoDocumentoIdentidadDTO obtenerTipoDocumentoIdentidadPorID(long id);

    String eliminarTipoDocumentoIdentidad(long id);
}
