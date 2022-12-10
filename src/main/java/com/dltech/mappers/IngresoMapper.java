package com.dltech.mappers;

import com.dltech.dtos.IngresoDTO;
import com.dltech.model.Ingreso;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IngresoMapper {
    IngresoMapper instancia= Mappers.getMapper(IngresoMapper.class);

    IngresoDTO ingresoAIngresoDTO(Ingreso ingreso);
    Ingreso ingresoDTOAIngreso(IngresoDTO ingresoDTO);
    List<IngresoDTO> listaIngresoAListaIngresoDTO (List<Ingreso> listaIngreso);
}
