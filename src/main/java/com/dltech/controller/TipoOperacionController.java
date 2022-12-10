package com.dltech.controller;


import com.dltech.dtos.TipoOperacionDTO;
import com.dltech.service.TipoOperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TipoOperacionController {
    @Autowired
    private TipoOperacionService tipoOperacionService;

    @GetMapping("tipoOperaciones")
    public ResponseEntity<List<TipoOperacionDTO>> listarTipoOperacions(){
        return new ResponseEntity<>(tipoOperacionService.listarTipoOperacions(), HttpStatus.OK);
    }

    @GetMapping("/tipoOperaciones/{tipoOperacionId}")
    public ResponseEntity<TipoOperacionDTO> obtenerTipoOperacionPorID(@PathVariable("tipoOperacionId") long tipoOperacionId){
        return new ResponseEntity<>(tipoOperacionService.obtenerTipoOperacionPorID(tipoOperacionId), HttpStatus.OK);
    }


    @DeleteMapping("/tipoOperaciones/{tipoOperacionId}")
    public ResponseEntity<String> eliminarTipoOperacion(@PathVariable("tipoOperacionId") long tipoOperacionId){
        return new ResponseEntity<>(tipoOperacionService.eliminarTipoOperacion(tipoOperacionId), HttpStatus.OK);
    }
}
