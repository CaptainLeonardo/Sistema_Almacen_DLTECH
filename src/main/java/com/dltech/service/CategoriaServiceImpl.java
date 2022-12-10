package com.dltech.service;


import com.dltech.dtos.CategoriaDTO;
import com.dltech.mappers.CategoriaMapper;
import com.dltech.model.Categoria;
import com.dltech.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> listarCategorias() {
        return CategoriaMapper.instancia.listaCategoriaAListaCategoriaDTO(categoriaRepository.findAll());
    }

    @Override
    public CategoriaDTO obtenerCategoriaPorID(long id) {
        Optional<Categoria> categoria =categoriaRepository.findById(id);
        CategoriaDTO categoriaDTO;
        if (categoria.isPresent()){
            categoriaDTO = CategoriaMapper.instancia.categoriaACategoriaDTO(categoria.get());
        }else{
            categoriaDTO=null;
        }
        return categoriaDTO;
    }

    @Override
    public String eliminarCategoria(long id) {
        Optional<Categoria> categoriaOptional =categoriaRepository.findById(id);
        String result;
        if (categoriaOptional.isPresent()){
            categoriaRepository.delete(categoriaOptional.get());
            result="Registro Eliminado";
        }else{
            result="No se pudo realizar la eliminación";
        }
        return result;
    }
}
