package com.dltech.controller;


import com.dltech.dtos.SalidaDTO;
import com.dltech.service.SalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SalidaController {
    @Autowired
    private SalidaService salidaService;

    @GetMapping("salidas")
    public ResponseEntity<List<SalidaDTO>> listarSalidas(){
        return new ResponseEntity<>(salidaService.listarSalidas(), HttpStatus.OK);
    }

    @GetMapping("salidas/{salidaId}")
    public ResponseEntity<SalidaDTO> obtenerSalidaPorId(@PathVariable("salidaId") long salidaId){
        return new ResponseEntity<>(salidaService.obtenerSalidaPorID(salidaId), HttpStatus.OK);
    }

    @PostMapping("salidas")
    public ResponseEntity<SalidaDTO> registrarSalida(@RequestBody SalidaDTO salidaDTO){
        return new ResponseEntity<>(salidaService.registrarSalida(salidaDTO), HttpStatus.OK);
    }
}
