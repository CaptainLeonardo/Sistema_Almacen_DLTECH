package com.dltech.service;

import com.dltech.dtos.IngresoDTO;

import java.util.List;

public interface IngresoService {
    List<IngresoDTO> listarIngresos();
    IngresoDTO obtenerIngresoPorID(long id);
    IngresoDTO registrarIngreso(IngresoDTO ingresoDTO);
}
