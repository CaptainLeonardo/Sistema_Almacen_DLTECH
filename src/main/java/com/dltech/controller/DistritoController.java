package com.dltech.controller;


import com.dltech.dtos.DistritoDTO;
import com.dltech.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DistritoController {
    @Autowired
    private DistritoService distritoService;

    @GetMapping("distritos")
    public ResponseEntity<List<DistritoDTO>> listarDistritos(){
        return new ResponseEntity<>(distritoService.listarDistritos(), HttpStatus.OK);
    }

    @GetMapping("/distritos/{distritoId}")
    public ResponseEntity<DistritoDTO> obtenerDistritoPorID(@PathVariable("distritoId") long distritoId){
        return new ResponseEntity<>(distritoService.obtenerDistritoPorID(distritoId), HttpStatus.OK);
    }
    

    @DeleteMapping("/distritos/{distritoId}")
    public ResponseEntity<String> eliminarDistrito(@PathVariable("distritoId") long distritoId){
        return new ResponseEntity<>(distritoService.eliminarDistrito(distritoId), HttpStatus.OK);
    }
}
