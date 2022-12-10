package com.dltech.mappers;


import com.dltech.dtos.SalidaDetalleDTO;
import com.dltech.model.SalidaDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SalidaDetalleMapper {
    SalidaDetalleMapper instancia= Mappers.getMapper(SalidaDetalleMapper.class);

    SalidaDetalleDTO salidaDetalleASalidaDetalleDTO(SalidaDetalle salidaDetalle);
    SalidaDetalle salidaDetalleDTOASalidaDetalle(SalidaDetalleDTO salidaDetalleDTO);
    List<SalidaDetalleDTO> listaSalidaDetalleAListaSalidaDetalleDTO (List<SalidaDetalle> listaSalidaDetalle);

    List<SalidaDetalle> listaSalidaDetalleDTOAListaSalidaDetalle (List<SalidaDetalleDTO> listaSalidaDetalleDTO);
}
