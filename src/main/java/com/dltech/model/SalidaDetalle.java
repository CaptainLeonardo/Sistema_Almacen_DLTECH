package com.dltech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name="tb_salidaDetalle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalidaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalidaDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSalida")
    private Salida salida;

    @OneToOne()
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(nullable = false)
    private BigDecimal precioVenta;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private String serieProd;
}
