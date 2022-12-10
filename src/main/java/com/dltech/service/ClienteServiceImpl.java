package com.dltech.service;

import com.dltech.dtos.ClienteCreateDTO;
import com.dltech.dtos.ClienteDTO;
import com.dltech.dtos.ClienteUpdateDTO;
import com.dltech.mappers.ClienteMapper;
import com.dltech.model.Cliente;
import com.dltech.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> listarClientes() {
        return ClienteMapper.INSTANCIA.listarClienteAListarClienteDTO(clienteRepository.findAll());
    }

    @Override
    public ClienteDTO obtenerClientePorID(long id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);
        ClienteDTO clienteDTO;
        if(cliente.isPresent()){
            clienteDTO = ClienteMapper.INSTANCIA.clienteAClienteDTO(cliente.get());
        }else{
            clienteDTO = null;
        }
        return clienteDTO;
    }

    @Override
    public ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO) {
        Cliente cliente = ClienteMapper.INSTANCIA.clienteCreateDTOACliente(clienteCreateDTO);
        Cliente respuestaEntity = clienteRepository.save(cliente);
        ClienteDTO respuestaDTO = ClienteMapper.INSTANCIA.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO) {
        Cliente cliente = ClienteMapper.INSTANCIA.clienteUpdateDTOACliente(clienteUpdateDTO);
        Cliente respuestaEntity = clienteRepository.save(cliente);
        ClienteDTO respuestaDTO = ClienteMapper.INSTANCIA.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarCliente(long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        String resultado;
        if(clienteOptional.isPresent()){
            clienteRepository.delete(clienteOptional.get());
            resultado = "Cliente Eliminado";
        }else{
            resultado = "No se pudo realizar la eliminación";
        }
        return resultado;
    }
}
