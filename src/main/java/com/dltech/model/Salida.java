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
@Table(name="tb_salida")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Salida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalida;

    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(length = 3,nullable = false)
    private String docSerie;

    @Column(length = 8, nullable = false)
    private String docNum;

    @Column(nullable = false)
    private BigDecimal total;

    @OneToMany(mappedBy = "salida")
    private List<SalidaDetalle> salidaDetalle;
}
