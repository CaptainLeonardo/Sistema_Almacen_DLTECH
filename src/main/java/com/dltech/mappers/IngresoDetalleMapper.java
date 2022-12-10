package com.dltech.mappers;

import com.dltech.dtos.IngresoDetalleDTO;
import com.dltech.model.IngresoDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IngresoDetalleMapper {
    IngresoDetalleMapper instancia= Mappers.getMapper(IngresoDetalleMapper.class);

    IngresoDetalleDTO ingresoDetalleAIngresoDetalleDTO(IngresoDetalle ingresoDetalle);
    IngresoDetalle ingresoDetalleDTOAIngresoDetalle(IngresoDetalleDTO ingresoDetalleDTO);
    List<IngresoDetalleDTO> listaIngresoDetalleAListaIngresoDetalleDTO (List<IngresoDetalle> listaIngresoDetalle);

    List<IngresoDetalle> listaIngresoDetalleDTOAListaIngresoDetalle (List<IngresoDetalleDTO> listaIngresoDetalleDTO);
}
