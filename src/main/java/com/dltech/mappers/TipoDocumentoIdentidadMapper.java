package com.dltech.mappers;


import com.dltech.dtos.TipoDocumentoIdentidadDTO;
import com.dltech.model.TipoDocumentoIdentidad;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TipoDocumentoIdentidadMapper {
    TipoDocumentoIdentidadMapper instancia = Mappers.getMapper(TipoDocumentoIdentidadMapper.class);

    TipoDocumentoIdentidadDTO tipoDocumentoIdentidadATipoDocumentoIdentidadDTO(TipoDocumentoIdentidad tipoDocumentoIdentidad);
    TipoDocumentoIdentidad tipoDocumentoIdentidadDTOATipoDocumentoIdentidad(TipoDocumentoIdentidadDTO tipoDocumentoIdentidadDTO);

    List<TipoDocumentoIdentidadDTO> listaTipoDocumentoIdentidadAListaTipoDocumentoIdentidadDTO(List<TipoDocumentoIdentidad> listaTipoDocumentoIdentidad);
}
