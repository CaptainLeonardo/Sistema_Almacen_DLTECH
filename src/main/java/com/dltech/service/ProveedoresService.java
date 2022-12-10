package com.dltech.service;

import com.dltech.dtos.*;

import java.util.List;

public interface ProveedoresService {
    List<ProveedoresDTO>  listarProveedores();
    ProveedoresDTO obtenerProveedorPorID(int id);
    ProveedoresDTO registrarProveedor(ProveedoresCreateDTO proveedoresCreateDTO);
    ProveedoresDTO actualizarProveedor(ProveedoresUpdateDTO proveedoresUpdateDTO);
    ProveedoresDTO eliminarProveedor(int id);
}
