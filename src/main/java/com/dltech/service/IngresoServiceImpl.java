package com.dltech.service;

import com.dltech.dtos.IngresoDTO;
import com.dltech.dtos.IngresoDetalleDTO;
import com.dltech.mappers.IngresoDetalleMapper;
import com.dltech.mappers.IngresoMapper;
import com.dltech.model.Ingreso;
import com.dltech.model.IngresoDetalle;
import com.dltech.repository.IngresoDetalleRepository;
import com.dltech.repository.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngresoServiceImpl implements IngresoService{

    @Autowired
    private IngresoRepository ingresoRepository;
    @Autowired
    private IngresoDetalleRepository ingresoDetalleRepository;

    @Override
    public List<IngresoDTO> listarIngresos() {
        List<IngresoDTO> lista= IngresoMapper.instancia.listaIngresoAListaIngresoDTO(ingresoRepository.findAll());
        for (int x=0;x<lista.size();x++){
            lista.get(x).setIngresoDetalleDTO(
                    IngresoDetalleMapper.instancia.listaIngresoDetalleAListaIngresoDetalleDTO(ingresoDetalleRepository.getIngresoDetalleByIngresoIdIngreso(lista.get(x).getIdIngreso()))
            );
        }
        return lista;
    }

    @Override
    public IngresoDTO obtenerIngresoPorID(long id) {
        Optional<Ingreso> ingreso=ingresoRepository.findById(id);
        IngresoDTO ingresoDTO;
        if (ingreso.isPresent()){
            ingresoDTO=IngresoMapper.instancia.ingresoAIngresoDTO(ingreso.get());
            ingresoDTO.setIngresoDetalleDTO(
                    IngresoDetalleMapper.instancia.listaIngresoDetalleAListaIngresoDetalleDTO(ingresoDetalleRepository.getIngresoDetalleByIngresoIdIngreso(ingreso.get().getIdIngreso()))
            );
        } else {
            ingresoDTO=null;
        }
        return ingresoDTO;
    }

    @Override
    public IngresoDTO registrarIngreso(IngresoDTO ingresoDTO) {
        Ingreso ingreso=IngresoMapper.instancia.ingresoDTOAIngreso(ingresoDTO);
        Ingreso respuestaEntity=ingresoRepository.save(ingreso);

        for (IngresoDetalleDTO ingresoDetalleDTO : ingresoDTO.getIngresoDetalleDTO()){
            IngresoDetalle pd=IngresoDetalleMapper.instancia.ingresoDetalleDTOAIngresoDetalle(ingresoDetalleDTO);
            pd.setIngreso(respuestaEntity);
            ingresoDetalleRepository.save(pd);
        }

        IngresoDTO respuestaDTO = IngresoMapper.instancia.ingresoAIngresoDTO(ingresoRepository.getById(respuestaEntity.getIdIngreso()));
        respuestaDTO.setIngresoDetalleDTO(
                IngresoDetalleMapper.instancia.listaIngresoDetalleAListaIngresoDetalleDTO(ingresoDetalleRepository.getIngresoDetalleByIngresoIdIngreso(respuestaEntity.getIdIngreso()))
        );

        return respuestaDTO;
    }
}
