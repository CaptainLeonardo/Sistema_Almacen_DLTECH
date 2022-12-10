package com.dltech.service;

import com.dltech.dtos.ProveedoresCreateDTO;
import com.dltech.dtos.ProveedoresDTO;
import com.dltech.dtos.ProveedoresUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dltech.model.Proveedores;
import com.dltech.repository.ProveedoresRepository;
import com.dltech.mappers.ProveedoresMapper;
import java.util.List;
import java.util.Optional;

@Service
public class ProveedoresServiceImpl implements ProveedoresService{

    @Autowired
    private ProveedoresRepository  proveedoresRepository;

    @Override
    public List<ProveedoresDTO> listarProveedores() {
        return ProveedoresMapper.instancia.listaProveedoresAListaProveedoresDTO( proveedoresRepository.findAll());
    }

    @Override
    public ProveedoresDTO obtenerProveedorPorID(int id) {
        Optional<Proveedores> proveedor = proveedoresRepository.findById(id);
        ProveedoresDTO proveedoresDTO ;
        if(proveedor.isPresent()){
            proveedoresDTO = ProveedoresMapper.instancia.proveedoresAProveedoresDTO(proveedor.get());
        }else {
            proveedoresDTO=null;
        }
        return  proveedoresDTO;
    }

    @Override
    public ProveedoresDTO registrarProveedor(ProveedoresCreateDTO proveedoresCreateDTO) {
        Proveedores proveedores=ProveedoresMapper.instancia.proveedoresCreateDTOAProveedores(proveedoresCreateDTO);
        Proveedores respuestaEntity = proveedoresRepository.save(proveedores);
        ProveedoresDTO respuestaDTO = ProveedoresMapper.instancia.proveedoresAProveedoresDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ProveedoresDTO actualizarProveedor(ProveedoresUpdateDTO proveedoresUpdateDTO) {
        Proveedores proveedores = ProveedoresMapper.instancia.proveedoresUpdateDTOAProveedores(proveedoresUpdateDTO);
        Proveedores respuestaEntity = proveedoresRepository.save(proveedores);
        ProveedoresDTO respuestaDTO = ProveedoresMapper.instancia.proveedoresAProveedoresDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ProveedoresDTO eliminarProveedor(int id) {
        Optional<Proveedores> proveedoresOptional= proveedoresRepository.findById(id);
        ProveedoresDTO proveedoresDTO = new ProveedoresDTO();
        String resultado ;
        if(proveedoresOptional.isPresent()){
            proveedoresDTO = ProveedoresMapper.instancia.proveedoresAProveedoresDTO(proveedoresOptional.get());
            proveedoresRepository.delete(proveedoresOptional.get());
            return proveedoresDTO;
        }else {
            resultado="No se pudo realizar la eliminación";
        }
        return proveedoresDTO;
    }
}
