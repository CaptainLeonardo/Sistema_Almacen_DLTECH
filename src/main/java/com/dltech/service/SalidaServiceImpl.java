package com.dltech.service;

import com.dltech.dtos.SalidaDTO;
import com.dltech.dtos.SalidaDetalleDTO;
import com.dltech.mappers.SalidaDetalleMapper;
import com.dltech.mappers.SalidaMapper;
import com.dltech.model.Salida;
import com.dltech.model.SalidaDetalle;
import com.dltech.repository.SalidaDetalleRepository;
import com.dltech.repository.SalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalidaServiceImpl implements SalidaService{
    @Autowired
    private SalidaRepository salidaRepository;
    @Autowired
    private SalidaDetalleRepository salidaDetalleRepository;

    @Override
    public List<SalidaDTO> listarSalidas() {
        List<SalidaDTO> lista= SalidaMapper.instancia.listaSalidaAListaSalidaDTO(salidaRepository.findAll());
        for (int x=0;x<lista.size();x++){
            lista.get(x).setSalidaDetalleDTO(
                    SalidaDetalleMapper.instancia.listaSalidaDetalleAListaSalidaDetalleDTO(salidaDetalleRepository.getSalidaDetalleBySalidaIdSalida(lista.get(x).getIdSalida()))
            );
        }
        return lista;
    }

    @Override
    public SalidaDTO obtenerSalidaPorID(long id) {
        Optional<Salida> salida=salidaRepository.findById(id);
        SalidaDTO salidaDTO;
        if (salida.isPresent()){
            salidaDTO=SalidaMapper.instancia.salidaASalidaDTO(salida.get());
            salidaDTO.setSalidaDetalleDTO(
                    SalidaDetalleMapper.instancia.listaSalidaDetalleAListaSalidaDetalleDTO(salidaDetalleRepository.getSalidaDetalleBySalidaIdSalida(salidaDTO.getIdSalida()))
            );
        } else {
            salidaDTO=null;
        }
        return salidaDTO;
    }

    @Override
    public SalidaDTO registrarSalida(SalidaDTO salidaDTO) {
        Salida salida= SalidaMapper.instancia.salidaDTOASalida(salidaDTO);
        Salida respuestaEntity=salidaRepository.save(salida);

        for (SalidaDetalleDTO salidaDetalleDTO : salidaDTO.getSalidaDetalleDTO()){
            SalidaDetalle pd= SalidaDetalleMapper.instancia.salidaDetalleDTOASalidaDetalle(salidaDetalleDTO);
            pd.setSalida(respuestaEntity);
            salidaDetalleRepository.save(pd);
        }

        SalidaDTO respuestaDTO = SalidaMapper.instancia.salidaASalidaDTO(salidaRepository.getById(respuestaEntity.getIdSalida()));
        respuestaDTO.setSalidaDetalleDTO(
                SalidaDetalleMapper.instancia.listaSalidaDetalleAListaSalidaDetalleDTO(salidaDetalleRepository.getSalidaDetalleBySalidaIdSalida(respuestaEntity.getIdSalida()))
        );

        return respuestaDTO;
    }
}
