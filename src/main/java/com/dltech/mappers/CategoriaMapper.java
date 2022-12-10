package com.dltech.mappers;


import com.dltech.dtos.CategoriaDTO;
import com.dltech.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoriaMapper {
    CategoriaMapper instancia = Mappers.getMapper(CategoriaMapper.class);

    CategoriaDTO categoriaACategoriaDTO(Categoria categoria);
    Categoria categoriaDTOACategoria(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> listaCategoriaAListaCategoriaDTO(List<Categoria> listaCategoria);
}
