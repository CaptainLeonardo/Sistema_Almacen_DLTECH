package com.dltech.dtos;

import com.dltech.model.Cliente;
import com.dltech.model.Usuario;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SalidaDTO {
    private Long idSalida;
    private Date fecha;
    private Cliente cliente;
    private Usuario usuario;
    private String docSerie;
    private String docNum;
    private BigDecimal total;
    private List<SalidaDetalleDTO> salidaDetalleDTO;
}
