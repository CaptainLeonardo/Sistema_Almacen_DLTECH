package com.dltech.dtos;

import com.dltech.model.*;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class KardexDTO {
    private Long idKardex;
    private Producto producto;
    private Date fecha;
    private TipoDocumentoIdentidad tipoDocumentoIdentidad;
    private String docSerie;
    private String docNum;
    private Integer cantEntrada;
    private BigDecimal precioEntrada;
    private Integer cantSalida;
    private BigDecimal precioSalida;
    private TipoOperacion tipoOperacion;
    private Almacen almacen;
    private Usuario usuario;
}
