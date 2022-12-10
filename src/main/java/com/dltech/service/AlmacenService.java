package com.dltech.service;


import com.dltech.dtos.AlmacenDTO;

import java.util.List;

public interface AlmacenService {
    List<AlmacenDTO> listarAlmacens();

    AlmacenDTO obtenerAlmacenPorID(long id);

    String eliminarAlmacen(long id);
}
