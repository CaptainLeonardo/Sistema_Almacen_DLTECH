package com.dltech.service;



import com.dltech.dtos.SalidaDTO;

import java.util.List;

public interface SalidaService {
    List<SalidaDTO> listarSalidas();
    SalidaDTO obtenerSalidaPorID(long id);
    SalidaDTO registrarSalida(SalidaDTO salidaDTO);
}
