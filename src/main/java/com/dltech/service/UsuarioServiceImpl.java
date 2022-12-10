package com.dltech.service;

import com.dltech.dtos.UsuarioCreateDTO;
import com.dltech.dtos.UsuarioDTO;
import com.dltech.dtos.UsuarioUpdateDTO;
import com.dltech.mappers.UsuarioMapper;
import com.dltech.model.Usuario;
import com.dltech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import com.security.config.WebSecurityConfig.*;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return UsuarioMapper.instancia.listaUsuarioAListaUsuarioDTO(usuarioRepository.findAll());
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorID(long id) {
        Optional<Usuario> usuario =usuarioRepository.findById(id);
        UsuarioDTO usuarioDTO;
        if (usuario.isPresent()){
            usuarioDTO = UsuarioMapper.instancia.usuarioAUsuarioDTO(usuario.get());
        }else{
            usuarioDTO=null;
        }
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO getUserByNameAndPassword(String user, String password) {
        Optional<Usuario> usuario =usuarioRepository.findUsuarioByUsuarioAndClave(user, password);
        UsuarioDTO usuarioDTO;
        if (usuario.isPresent()){
            usuarioDTO = UsuarioMapper.instancia.usuarioAUsuarioDTO(usuario.get());
        }else{
            usuarioDTO=null;
        }
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioCreateDTO UsuarioCreateDTO) {
        Usuario usuario=UsuarioMapper.instancia.usuarioCreateDTOAUsuario(UsuarioCreateDTO);
        Usuario respuestaEntity=usuarioRepository.save(usuario);
        UsuarioDTO respuestaDTO=UsuarioMapper.instancia.usuarioAUsuarioDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioUpdateDTO UsuarioUpdateDTO) {
        Usuario usuario=UsuarioMapper.instancia.usuarioUpdateDTOAUsuario(UsuarioUpdateDTO);
        Usuario respuestaEntity=usuarioRepository.save(usuario);
        UsuarioDTO respuestaDTO=UsuarioMapper.instancia.usuarioAUsuarioDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarUsuario(long id) {
        Optional<Usuario> usuarioOptional =usuarioRepository.findById(id);
        String result;
        if (usuarioOptional.isPresent()){
            usuarioRepository.delete(usuarioOptional.get());
            result="Registro Eliminado";
        }else{
            result="No se pudo realizar la eliminación";
        }
        return result;
    }
}
