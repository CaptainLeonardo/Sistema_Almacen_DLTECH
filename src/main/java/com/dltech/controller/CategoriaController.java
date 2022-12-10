package com.dltech.controller;


import com.dltech.dtos.CategoriaDTO;
import com.dltech.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("categorias")
    public ResponseEntity<List<CategoriaDTO>> listarCategorias(){
        return new ResponseEntity<>(categoriaService.listarCategorias(), HttpStatus.OK);
    }

    @GetMapping("/categorias/{categoriaId}")
    public ResponseEntity<CategoriaDTO> obtenerCategoriaPorID(@PathVariable("categoriaId") long categoriaId){
        return new ResponseEntity<>(categoriaService.obtenerCategoriaPorID(categoriaId), HttpStatus.OK);
    }


    @DeleteMapping("/categorias/{categoriaId}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable("categoriaId") long categoriaId){
        return new ResponseEntity<>(categoriaService.eliminarCategoria(categoriaId), HttpStatus.OK);
    }
}
