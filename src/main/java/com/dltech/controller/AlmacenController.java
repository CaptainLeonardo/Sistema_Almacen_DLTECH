package com.dltech.controller;


import com.dltech.dtos.AlmacenDTO;
import com.dltech.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;

    @GetMapping("almacenes")
    public ResponseEntity<List<AlmacenDTO>> listarAlmacens(){
        return new ResponseEntity<>(almacenService.listarAlmacens(), HttpStatus.OK);
    }

    @GetMapping("/almacenes/{almacenId}")
    public ResponseEntity<AlmacenDTO> obtenerAlmacenPorID(@PathVariable("almacenId") long almacenId){
        return new ResponseEntity<>(almacenService.obtenerAlmacenPorID(almacenId), HttpStatus.OK);
    }


    @DeleteMapping("/almacenes/{almacenId}")
    public ResponseEntity<String> eliminarAlmacen(@PathVariable("almacenId") long almacenId){
        return new ResponseEntity<>(almacenService.eliminarAlmacen(almacenId), HttpStatus.OK);
    }
}
