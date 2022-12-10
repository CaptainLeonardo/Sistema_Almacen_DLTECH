package com.dltech.service;


import com.dltech.dtos.DistritoDTO;
import com.dltech.mappers.DistritoMapper;
import com.dltech.model.Distrito;
import com.dltech.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistritoServiceImpl implements DistritoService{

    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public List<DistritoDTO> listarDistritos() {
        return DistritoMapper.instancia.listaDistritoAListaDistritoDTO(distritoRepository.findAll());
    }

    @Override
    public DistritoDTO obtenerDistritoPorID(long id) {
        Optional<Distrito> distrito =distritoRepository.findById(id);
        DistritoDTO distritoDTO;
        if (distrito.isPresent()){
            distritoDTO = DistritoMapper.instancia.distritoADistritoDTO(distrito.get());
        }else{
            distritoDTO=null;
        }
        return distritoDTO;
    }

    @Override
    public String eliminarDistrito(long id) {
        Optional<Distrito> distritoOptional =distritoRepository.findById(id);
        String result;
        if (distritoOptional.isPresent()){
            distritoRepository.delete(distritoOptional.get());
            result="Registro Eliminado";
        }else{
            result="No se pudo realizar la eliminación";
        }
        return result;
    }
}
