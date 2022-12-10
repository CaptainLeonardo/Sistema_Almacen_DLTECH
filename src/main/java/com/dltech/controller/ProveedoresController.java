package com.dltech.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dltech.dtos.ProveedoresCreateDTO;
import com.dltech.dtos.ProveedoresDTO;
import com.dltech.dtos.ProveedoresUpdateDTO;
import com.dltech.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProveedoresController {
    @Autowired
    private ProveedoresService proveedoresService;

    @GetMapping("proveedores")
    public ResponseEntity<List<ProveedoresDTO>> listarProveedores(){
        return   new ResponseEntity<>(proveedoresService.listarProveedores(), HttpStatus.OK);
    }

    @GetMapping("/proveedores/{proveedorId}")
    public ResponseEntity<ProveedoresDTO> obtenerProveedorPorId(@PathVariable("proveedorId") int proveedorId){
        return  new ResponseEntity<> ( proveedoresService.obtenerProveedorPorID(proveedorId),HttpStatus.OK);
    }

    @PostMapping("proveedores")
    public ResponseEntity<ProveedoresDTO> registrarProveedor(@RequestBody ProveedoresCreateDTO proveedoresCreateDTO){
        return  new ResponseEntity <>( proveedoresService.registrarProveedor(proveedoresCreateDTO) ,HttpStatus.OK) ;
    }

    @PutMapping("proveedores")
    public ResponseEntity<ProveedoresDTO> actualizarProveedor(@RequestBody ProveedoresUpdateDTO proveedoresUpdateDTO){
        return new ResponseEntity<>(proveedoresService.actualizarProveedor(proveedoresUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/proveedores/{proveedorId}")
    public ResponseEntity<ProveedoresDTO> eliminarProveedor(@PathVariable("proveedorId") int proveedorId) {
        return new ResponseEntity<>( proveedoresService.eliminarProveedor(proveedorId),HttpStatus.OK);
    }
}
