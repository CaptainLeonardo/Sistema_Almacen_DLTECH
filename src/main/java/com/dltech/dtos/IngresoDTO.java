package com.dltech.dtos;

import com.dltech.model.IngresoDetalle;
import com.dltech.model.Proveedores;
import com.dltech.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class IngresoDTO {
    private Long idIngreso;
    private Date fecha;
    private Proveedores proveedor;
    private Usuario usuario;
    private String docSerie;
    private String docNum;
    private BigDecimal total;
    private List<IngresoDetalleDTO> ingresoDetalleDTO;
}
