package com.dltech.mappers;


import com.dltech.dtos.DistritoDTO;
import com.dltech.model.Distrito;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DistritoMapper {
    DistritoMapper instancia = Mappers.getMapper(DistritoMapper.class);

    DistritoDTO distritoADistritoDTO(Distrito distrito);
    Distrito distritoDTOADistrito(DistritoDTO distritoDTO);

    List<DistritoDTO> listaDistritoAListaDistritoDTO(List<Distrito> listaDistrito);
}
