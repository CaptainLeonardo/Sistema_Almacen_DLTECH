package com.dltech.service;


import com.dltech.dtos.TipoOperacionDTO;
import com.dltech.mappers.TipoOperacionMapper;
import com.dltech.model.TipoOperacion;
import com.dltech.repository.TipoOperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoOperacionServiceImpl implements TipoOperacionService{

    @Autowired
    private TipoOperacionRepository tipoOperacionRepository;

    @Override
    public List<TipoOperacionDTO> listarTipoOperacions() {
        return TipoOperacionMapper.instancia.listaTipoOperacionAListaTipoOperacionDTO(tipoOperacionRepository.findAll());
    }

    @Override
    public TipoOperacionDTO obtenerTipoOperacionPorID(long id) {
        Optional<TipoOperacion> tipoOperacion =tipoOperacionRepository.findById(id);
        TipoOperacionDTO tipoOperacionDTO;
        if (tipoOperacion.isPresent()){
            tipoOperacionDTO = TipoOperacionMapper.instancia.tipoOperacionATipoOperacionDTO(tipoOperacion.get());
        }else{
            tipoOperacionDTO=null;
        }
        return tipoOperacionDTO;
    }

    @Override
    public String eliminarTipoOperacion(long id) {
        Optional<TipoOperacion> tipoOperacionOptional =tipoOperacionRepository.findById(id);
        String result;
        if (tipoOperacionOptional.isPresent()){
            tipoOperacionRepository.delete(tipoOperacionOptional.get());
            result="Registro Eliminado";
        }else{
            result="No se pudo realizar la eliminación";
        }
        return result;
    }
}
