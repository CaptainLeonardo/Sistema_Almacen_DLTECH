package com.dltech.mappers;


import com.dltech.dtos.SalidaDTO;
import com.dltech.model.Salida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SalidaMapper {
    SalidaMapper instancia= Mappers.getMapper(SalidaMapper.class);

    SalidaDTO salidaASalidaDTO(Salida salida);
    Salida salidaDTOASalida(SalidaDTO salidaDTO);
    List<SalidaDTO> listaSalidaAListaSalidaDTO (List<Salida> listaSalida);
}
