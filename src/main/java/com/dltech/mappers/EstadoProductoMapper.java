package com.dltech.mappers;


import com.dltech.dtos.EstadoProductoDTO;
import com.dltech.model.EstadoProducto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EstadoProductoMapper {
    EstadoProductoMapper instancia = Mappers.getMapper(EstadoProductoMapper.class);

    EstadoProductoDTO estadoProductoAEstadoProductoDTO(EstadoProducto estadoProducto);
    EstadoProducto estadoProductoDTOAEstadoProducto(EstadoProductoDTO estadoProductoDTO);

    List<EstadoProductoDTO> listaEstadoProductoAListaEstadoProductoDTO(List<EstadoProducto> listaEstadoProducto);
}
