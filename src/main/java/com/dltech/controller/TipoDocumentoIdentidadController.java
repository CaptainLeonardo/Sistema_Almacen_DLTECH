package com.dltech.controller;


import com.dltech.dtos.TipoDocumentoIdentidadDTO;
import com.dltech.service.TipoDocumentoIdentidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TipoDocumentoIdentidadController {
    @Autowired
    private TipoDocumentoIdentidadService tipoDocumentoIdentidadService;

    @GetMapping("tipoDocumentoIdentidades")
    public ResponseEntity<List<TipoDocumentoIdentidadDTO>> listarTipoDocumentoIdentidads(){
        return new ResponseEntity<>(tipoDocumentoIdentidadService.listarTipoDocumentoIdentidads(), HttpStatus.OK);
    }

    @GetMapping("/tipoDocumentoIdentidades/{tipoDocumentoIdentidadId}")
    public ResponseEntity<TipoDocumentoIdentidadDTO> obtenerTipoDocumentoIdentidadPorID(@PathVariable("tipoDocumentoIdentidadId") long tipoDocumentoIdentidadId){
        return new ResponseEntity<>(tipoDocumentoIdentidadService.obtenerTipoDocumentoIdentidadPorID(tipoDocumentoIdentidadId), HttpStatus.OK);
    }


    @DeleteMapping("/tipoDocumentoIdentidades/{tipoDocumentoIdentidadId}")
    public ResponseEntity<String> eliminarTipoDocumentoIdentidad(@PathVariable("tipoDocumentoIdentidadId") long tipoDocumentoIdentidadId){
        return new ResponseEntity<>(tipoDocumentoIdentidadService.eliminarTipoDocumentoIdentidad(tipoDocumentoIdentidadId), HttpStatus.OK);
    }
}
