package com.dltech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tb_kardex")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Kardex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKardex;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idTipoDocumentoIndetidad")
    private TipoDocumentoIdentidad tipoDocumentoIdentidad;

    @Column(length = 3, nullable = false)
    private String docSerie;

    @Column(length = 8, nullable = false)
    private String docNum;


    private Integer cantEntrada;

    private BigDecimal precioEntrada;

    private Integer cantSalida;

    private BigDecimal precioSalida;

    @ManyToOne
    @JoinColumn(name = "idTipoOperacion")
    private TipoOperacion tipoOperacion;

    @ManyToOne
    @JoinColumn(name = "idAlmacen")
    private Almacen almacen;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;


}
