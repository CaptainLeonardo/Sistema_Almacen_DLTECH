package com.dltech.mappers;

import org.mapstruct.Mapper;
import com.dltech.dtos.ProveedoresCreateDTO;
import com.dltech.dtos.ProveedoresDTO;
import com.dltech.dtos.ProveedoresUpdateDTO;
import com.dltech.model.Proveedores;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface ProveedoresMapper {
    ProveedoresMapper instancia= Mappers.getMapper(ProveedoresMapper.class);
    ProveedoresDTO proveedoresAProveedoresDTO(Proveedores proveedores);
    Proveedores proveedoresDTOAProveedores(ProveedoresDTO proveedoresDTO);
    Proveedores proveedoresCreateDTOAProveedores(ProveedoresCreateDTO proveedoresCreateDTO);
    Proveedores proveedoresUpdateDTOAProveedores(ProveedoresUpdateDTO proveedoresUpdateDTO);
    List<ProveedoresDTO> listaProveedoresAListaProveedoresDTO (List<Proveedores> listaProveedores);
}
