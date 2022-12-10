package com.dltech.service;


import com.dltech.dtos.TipoDocumentoIdentidadDTO;
import com.dltech.mappers.TipoDocumentoIdentidadMapper;
import com.dltech.model.TipoDocumentoIdentidad;
import com.dltech.repository.TipoDocumentoIdentidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoIdentidadServiceImpl implements TipoDocumentoIdentidadService{

    @Autowired
    private TipoDocumentoIdentidadRepository tipoDocumentoIdentidadRepository;

    @Override
    public List<TipoDocumentoIdentidadDTO> listarTipoDocumentoIdentidads() {
        return TipoDocumentoIdentidadMapper.instancia.listaTipoDocumentoIdentidadAListaTipoDocumentoIdentidadDTO(tipoDocumentoIdentidadRepository.findAll());
    }

    @Override
    public TipoDocumentoIdentidadDTO obtenerTipoDocumentoIdentidadPorID(long id) {
        Optional<TipoDocumentoIdentidad> tipoDocumentoIdentidad =tipoDocumentoIdentidadRepository.findById(id);
        TipoDocumentoIdentidadDTO tipoDocumentoIdentidadDTO;
        if (tipoDocumentoIdentidad.isPresent()){
            tipoDocumentoIdentidadDTO = TipoDocumentoIdentidadMapper.instancia.tipoDocumentoIdentidadATipoDocumentoIdentidadDTO(tipoDocumentoIdentidad.get());
        }else{
            tipoDocumentoIdentidadDTO=null;
        }
        return tipoDocumentoIdentidadDTO;
    }

    @Override
    public String eliminarTipoDocumentoIdentidad(long id) {
        Optional<TipoDocumentoIdentidad> tipoDocumentoIdentidadOptional =tipoDocumentoIdentidadRepository.findById(id);
        String result;
        if (tipoDocumentoIdentidadOptional.isPresent()){
            tipoDocumentoIdentidadRepository.delete(tipoDocumentoIdentidadOptional.get());
            result="Registro Eliminado";
        }else{
            result="No se pudo realizar la eliminación";
        }
        return result;
    }
}
