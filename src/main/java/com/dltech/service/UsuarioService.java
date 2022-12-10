package com.dltech.service;

import com.dltech.dtos.UsuarioCreateDTO;
import com.dltech.dtos.UsuarioDTO;
import com.dltech.dtos.UsuarioUpdateDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> listarUsuarios();

    UsuarioDTO obtenerUsuarioPorID(long id);

    UsuarioDTO getUserByNameAndPassword(String user, String password);

    UsuarioDTO registrarUsuario(UsuarioCreateDTO UsuarioCreateDTO);

    UsuarioDTO actualizarUsuario(UsuarioUpdateDTO UsuarioUpdateDTO);

    String eliminarUsuario(long id);
}
