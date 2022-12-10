package com.dltech.controller;

import com.dltech.dtos.IngresoDTO;
import com.dltech.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class IngresoController {
    @Autowired
    private IngresoService ingresoService;

    @GetMapping("ingresos")
    public ResponseEntity<List<IngresoDTO>> listarIngresos(){
        return new ResponseEntity<>(ingresoService.listarIngresos(), HttpStatus.OK);
    }

    @GetMapping("ingresos/{ingresoId}")
    public ResponseEntity<IngresoDTO> obtenerIngresoPorId(@PathVariable("ingresoId") long ingresoId){
        return new ResponseEntity<>(ingresoService.obtenerIngresoPorID(ingresoId), HttpStatus.OK);
    }

    @PostMapping("ingresos")
    public ResponseEntity<IngresoDTO> registrarIngreso(@RequestBody IngresoDTO ingresoDTO){
        return new ResponseEntity<>(ingresoService.registrarIngreso(ingresoDTO), HttpStatus.OK);
    }
}
