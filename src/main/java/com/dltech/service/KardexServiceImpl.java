package com.dltech.service;

import com.dltech.dtos.KardexCreateDTO;
import com.dltech.dtos.KardexDTO;
import com.dltech.mappers.KardexMapper;
import com.dltech.model.Kardex;
import com.dltech.repository.KardexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KardexServiceImpl implements KardexService{

    @Autowired
    private KardexRepository kardexRepository;

    @Override
    public List<KardexDTO> listarKardex() {
        return KardexMapper.instancia.listaKardexAListaKardexDTO(kardexRepository.findAll());
    }

    @Override
    public KardexDTO obtenerKardexPorID(long id) {
        Optional<Kardex> kardex =kardexRepository.findById(id);
        KardexDTO kardexDTO;
        if (kardex.isPresent()){
            kardexDTO = KardexMapper.instancia.kardexAKardexDTO(kardex.get());
        }else{
            kardexDTO=null;
        }
        return kardexDTO;
    }

    @Override
    public KardexDTO registrarKarder(KardexCreateDTO kardexCreateDTO) {
        Kardex producto=KardexMapper.instancia.kardexCreateDTOAKardex(kardexCreateDTO);
        Kardex respuestaEntity=kardexRepository.save(producto);
        KardexDTO respuestaDTO=KardexMapper.instancia.kardexAKardexDTO(respuestaEntity);
        return respuestaDTO;
    }
}
