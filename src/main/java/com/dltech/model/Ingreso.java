package com.dltech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tb_ingreso")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngreso;

    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idProv")
    private Proveedores proveedor;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(length = 3,nullable = false)
    private String docSerie;

    @Column(length = 8, nullable = false)
    private String docNum;

    @Column(nullable = false)
    private BigDecimal total;

    @OneToMany(mappedBy = "ingreso")
    private List<IngresoDetalle> ingresoDetalle;
}
