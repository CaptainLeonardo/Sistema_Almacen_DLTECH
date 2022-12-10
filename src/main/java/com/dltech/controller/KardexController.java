package com.dltech.controller;


import com.dltech.dtos.KardexCreateDTO;
import com.dltech.dtos.KardexDTO;
import com.dltech.service.KardexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KardexController {

    @Autowired
    private KardexService kardexService;

    @GetMapping("kardex")
    public ResponseEntity<List<KardexDTO>> listarKardex(){
        return new ResponseEntity<>(kardexService.listarKardex(), HttpStatus.OK);
    }

    @GetMapping("/kardex/{kardexId}")
    public ResponseEntity<KardexDTO> obtenerKardexPorID(@PathVariable("kardexId") long kardexId){
        return new ResponseEntity<>(kardexService.obtenerKardexPorID(kardexId), HttpStatus.OK);
    }

    @PostMapping("kardex")
    public ResponseEntity<KardexDTO> registrarKardex(@RequestBody KardexCreateDTO kardexCreateDTO){
        return new ResponseEntity<>(kardexService.registrarKarder(kardexCreateDTO), HttpStatus.OK);
    }
}
