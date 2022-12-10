package com.dltech.mappers;

import com.dltech.dtos.ProductoCreateDTO;
import com.dltech.dtos.ProductoDTO;
import com.dltech.dtos.ProductoUpdateDTO;
import com.dltech.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoMapper {
    ProductoMapper instancia = Mappers.getMapper(ProductoMapper.class);

    ProductoDTO productoAProductoDTO(Producto producto);
    Producto productoDTOAProducto(ProductoDTO productoDTO);
    Producto productoCreateDTOAProducto(ProductoCreateDTO productoCreateDTODTO);
    Producto productoUpdateDTOAProducto(ProductoUpdateDTO productoUpdateDTODTO);

    List<ProductoDTO> listaProductoAListaProductoDTO(List<Producto> listaProducto);
}
