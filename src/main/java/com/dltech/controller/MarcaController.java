package com.dltech.controller;


import com.dltech.dtos.MarcaDTO;
import com.dltech.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @GetMapping("marcas")
    public ResponseEntity<List<MarcaDTO>> listarMarcas(){
        return new ResponseEntity<>(marcaService.listarMarcas(), HttpStatus.OK);
    }

    @GetMapping("/marcas/{marcaId}")
    public ResponseEntity<MarcaDTO> obtenerMarcaPorID(@PathVariable("marcaId") long marcaId){
        return new ResponseEntity<>(marcaService.obtenerMarcaPorID(marcaId), HttpStatus.OK);
    }


    @DeleteMapping("/marcas/{marcaId}")
    public ResponseEntity<String> eliminarMarca(@PathVariable("marcaId") long marcaId){
        return new ResponseEntity<>(marcaService.eliminarMarca(marcaId), HttpStatus.OK);
    }
}
