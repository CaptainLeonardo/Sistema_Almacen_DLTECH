package com.dltech.dtos;

import com.dltech.model.Ingreso;
import com.dltech.model.Producto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
public class IngresoDetalleDTO {
    private Long idIngresoDetalle;
    private Producto producto;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private Integer cantidad;
    private String serieProd;
}
