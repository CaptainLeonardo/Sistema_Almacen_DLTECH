package com.dltech.dtos;

import com.dltech.model.Producto;
import com.dltech.model.Salida;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class SalidaDetalleDTO {
    private Long idSalidaDetalle;
    private Producto producto;
    private BigDecimal precioVenta;
    private Integer cantidad;
    private String serieProd;
}
