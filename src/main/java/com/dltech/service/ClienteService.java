package com.dltech.service;

import com.dltech.dtos.ClienteCreateDTO;
import com.dltech.dtos.ClienteDTO;
import com.dltech.dtos.ClienteUpdateDTO;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> listarClientes();
    ClienteDTO obtenerClientePorID(long id);
    ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO);
    ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO);
    String eliminarCliente(long id);
}
