package com.dltech.service;


import com.dltech.dtos.AlmacenDTO;
import com.dltech.mappers.AlmacenMapper;
import com.dltech.model.Almacen;
import com.dltech.repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenServiceImpl implements AlmacenService{

    @Autowired
    private AlmacenRepository almacenRepository;

    @Override
    public List<AlmacenDTO> listarAlmacens() {
        return AlmacenMapper.instancia.listaAlmacenAListaAlmacenDTO(almacenRepository.findAll());
    }

    @Override
    public AlmacenDTO obtenerAlmacenPorID(long id) {
        Optional<Almacen> almacen =almacenRepository.findById(id);
        AlmacenDTO almacenDTO;
        if (almacen.isPresent()){
            almacenDTO = AlmacenMapper.instancia.almacenAAlmacenDTO(almacen.get());
        }else{
            almacenDTO=null;
        }
        return almacenDTO;
    }

    @Override
    public String eliminarAlmacen(long id) {
        Optional<Almacen> almacenOptional =almacenRepository.findById(id);
        String result;
        if (almacenOptional.isPresent()){
            almacenRepository.delete(almacenOptional.get());
            result="Registro Eliminado";
        }else{
            result="No se pudo realizar la eliminación";
        }
        return result;
    }
}
