package com.dltech.mappers;


import com.dltech.dtos.AlmacenDTO;
import com.dltech.model.Almacen;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmacenMapper {
    AlmacenMapper instancia = Mappers.getMapper(AlmacenMapper.class);

    AlmacenDTO almacenAAlmacenDTO(Almacen almacen);
    Almacen almacenDTOAAlmacen(AlmacenDTO almacenDTO);

    List<AlmacenDTO> listaAlmacenAListaAlmacenDTO(List<Almacen> listaAlmacen);
}
