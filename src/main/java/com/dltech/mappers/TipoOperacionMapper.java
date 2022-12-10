package com.dltech.mappers;


import com.dltech.dtos.TipoOperacionDTO;
import com.dltech.model.TipoOperacion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TipoOperacionMapper {
    TipoOperacionMapper instancia = Mappers.getMapper(TipoOperacionMapper.class);

    TipoOperacionDTO tipoOperacionATipoOperacionDTO(TipoOperacion tipoOperacion);
    TipoOperacion tipoOperacionDTOATipoOperacion(TipoOperacionDTO tipoOperacionDTO);

    List<TipoOperacionDTO> listaTipoOperacionAListaTipoOperacionDTO(List<TipoOperacion> listaTipoOperacion);
}
