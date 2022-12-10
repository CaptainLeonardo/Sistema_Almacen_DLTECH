package com.dltech.service;


import com.dltech.dtos.MarcaDTO;
import com.dltech.mappers.MarcaMapper;
import com.dltech.model.Marca;
import com.dltech.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService{

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<MarcaDTO> listarMarcas() {
        return MarcaMapper.instancia.listaMarcaAListaMarcaDTO(marcaRepository.findAll());
    }

    @Override
    public MarcaDTO obtenerMarcaPorID(long id) {
        Optional<Marca> marca =marcaRepository.findById(id);
        MarcaDTO marcaDTO;
        if (marca.isPresent()){
            marcaDTO = MarcaMapper.instancia.marcaAMarcaDTO(marca.get());
        }else{
            marcaDTO=null;
        }
        return marcaDTO;
    }

    @Override
    public String eliminarMarca(long id) {
        Optional<Marca> marcaOptional =marcaRepository.findById(id);
        String result;
        if (marcaOptional.isPresent()){
            marcaRepository.delete(marcaOptional.get());
            result="Registro Eliminado";
        }else{
            result="No se pudo realizar la eliminación";
        }
        return result;
    }
}
