package com.dltech.service;



import com.dltech.dtos.KardexCreateDTO;
import com.dltech.dtos.KardexDTO;

import java.util.List;

public interface KardexService {
    List<KardexDTO> listarKardex();

    KardexDTO obtenerKardexPorID(long id);

    KardexDTO registrarKarder(KardexCreateDTO kardexCreateDTO);


}
