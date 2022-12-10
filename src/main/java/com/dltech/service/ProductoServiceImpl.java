package com.dltech.service;

import com.dltech.dtos.ProductoCreateDTO;
import com.dltech.dtos.ProductoDTO;
import com.dltech.dtos.ProductoUpdateDTO;
import com.dltech.mappers.ProductoMapper;
import com.dltech.model.Producto;
import com.dltech.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarProductos() {
        return ProductoMapper.instancia.listaProductoAListaProductoDTO(productoRepository.findAll());
    }

    @Override
    public ProductoDTO obtenerProductoPorID(long id) {
        Optional<Producto> producto =productoRepository.findById(id);
        ProductoDTO productoDTO;
        if (producto.isPresent()){
            productoDTO = ProductoMapper.instancia.productoAProductoDTO(producto.get());
        }else{
            productoDTO=null;
        }
        return productoDTO;
    }

    @Override
    public ProductoDTO registrarProducto(ProductoCreateDTO productoCreateDTO) {
        Producto producto=ProductoMapper.instancia.productoCreateDTOAProducto(productoCreateDTO);
        Producto respuestaEntity=productoRepository.save(producto);
        ProductoDTO respuestaDTO=ProductoMapper.instancia.productoAProductoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoUpdateDTO productoUpdateDTO) {
        Producto producto=ProductoMapper.instancia.productoUpdateDTOAProducto(productoUpdateDTO);
        Producto respuestaEntity=productoRepository.save(producto);
        ProductoDTO respuestaDTO=ProductoMapper.instancia.productoAProductoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarProducto(long id) {
        Optional<Producto> productoOptional =productoRepository.findById(id);
        String result;
        if (productoOptional.isPresent()){
            productoRepository.delete(productoOptional.get());
            result="Registro Eliminado";
        }else{
            result="No se pudo realizar la eliminación";
        }
        return result;
    }
}
