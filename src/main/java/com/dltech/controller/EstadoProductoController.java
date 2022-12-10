package com.dltech.controller;


import com.dltech.dtos.EstadoProductoDTO;
import com.dltech.service.EstadoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EstadoProductoController {
    @Autowired
    private EstadoProductoService estadoProductoService;

    @GetMapping("estadoProductos")
    public ResponseEntity<List<EstadoProductoDTO>> listarEstadoProductos(){
        return new ResponseEntity<>(estadoProductoService.listarEstadoProductos(), HttpStatus.OK);
    }

    @GetMapping("/estadoProductos/{estadoProductoId}")
    public ResponseEntity<EstadoProductoDTO> obtenerEstadoProductoPorID(@PathVariable("estadoProductoId") long estadoProductoId){
        return new ResponseEntity<>(estadoProductoService.obtenerEstadoProductoPorID(estadoProductoId), HttpStatus.OK);
    }


    @DeleteMapping("/estadoProductos/{estadoProductoId}")
    public ResponseEntity<String> eliminarEstadoProducto(@PathVariable("estadoProductoId") long estadoProductoId){
        return new ResponseEntity<>(estadoProductoService.eliminarEstadoProducto(estadoProductoId), HttpStatus.OK);
    }
}
