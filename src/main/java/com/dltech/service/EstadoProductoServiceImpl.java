package com.dltech.service;


import com.dltech.dtos.EstadoProductoDTO;
import com.dltech.mappers.EstadoProductoMapper;
import com.dltech.model.EstadoProducto;
import com.dltech.repository.EstadoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoProductoServiceImpl implements EstadoProductoService{

    @Autowired
    private EstadoProductoRepository estadoProductoRepository;

    @Override
    public List<EstadoProductoDTO> listarEstadoProductos() {
        return EstadoProductoMapper.instancia.listaEstadoProductoAListaEstadoProductoDTO(estadoProductoRepository.findAll());
    }

    @Override
    public EstadoProductoDTO obtenerEstadoProductoPorID(long id) {
        Optional<EstadoProducto> estadoProducto =estadoProductoRepository.findById(id);
        EstadoProductoDTO estadoProductoDTO;
        if (estadoProducto.isPresent()){
            estadoProductoDTO = EstadoProductoMapper.instancia.estadoProductoAEstadoProductoDTO(estadoProducto.get());
        }else{
            estadoProductoDTO=null;
        }
        return estadoProductoDTO;
    }

    @Override
    public String eliminarEstadoProducto(long id) {
        Optional<EstadoProducto> estadoProductoOptional =estadoProductoRepository.findById(id);
        String result;
        if (estadoProductoOptional.isPresent()){
            estadoProductoRepository.delete(estadoProductoOptional.get());
            result="Registro Eliminado";
        }else{
            result="No se pudo realizar la eliminación";
        }
        return result;
    }
}
