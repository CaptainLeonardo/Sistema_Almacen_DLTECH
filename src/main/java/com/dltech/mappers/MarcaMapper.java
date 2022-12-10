package com.dltech.mappers;


import com.dltech.dtos.MarcaDTO;
import com.dltech.model.Marca;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MarcaMapper {
    MarcaMapper instancia = Mappers.getMapper(MarcaMapper.class);

    MarcaDTO marcaAMarcaDTO(Marca marca);
    Marca marcaDTOAMarca(MarcaDTO marcaDTO);

    List<MarcaDTO> listaMarcaAListaMarcaDTO(List<Marca> listaMarca);
}
