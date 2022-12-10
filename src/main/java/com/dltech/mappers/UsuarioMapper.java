package com.dltech.mappers;

import com.dltech.dtos.*;
import com.dltech.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper instancia = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO usuarioAUsuarioDTO(Usuario usuario);
    Usuario usuarioDTOAUsuario(UsuarioDTO usuarioDTO);
    Usuario usuarioCreateDTOAUsuario(UsuarioCreateDTO usuarioCreateDTO);
    Usuario usuarioUpdateDTOAUsuario(UsuarioUpdateDTO usuarioUpdateDTO);

    List<UsuarioDTO> listaUsuarioAListaUsuarioDTO(List<Usuario> listaUsuario);
}
