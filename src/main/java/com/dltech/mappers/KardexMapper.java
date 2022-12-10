package com.dltech.mappers;

import com.dltech.dtos.KardexCreateDTO;
import com.dltech.dtos.KardexDTO;
import com.dltech.model.Kardex;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface KardexMapper {
    KardexMapper instancia = Mappers.getMapper(KardexMapper.class);

    KardexDTO kardexAKardexDTO(Kardex kardex);
    Kardex kardexDTOAKardex(KardexDTO kardexDTO);
    Kardex kardexCreateDTOAKardex(KardexCreateDTO kardexCreateDTO);

    List<KardexDTO> listaKardexAListaKardexDTO(List<Kardex> listaKardex);
}
