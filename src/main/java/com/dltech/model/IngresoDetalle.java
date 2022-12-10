package com.dltech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tb_ingresoDetalle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngresoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngresoDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idIngreso")
    private Ingreso ingreso;

    @OneToOne()
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(nullable = false)
    private BigDecimal precioCompra;

    @Column(nullable = false)
    private BigDecimal precioVenta;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private String serieProd;
}
