package com.dltech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(length = 100, nullable = false)
    private String nomApe;

    @Column(length = 12, nullable = false)
    private String docIdent;

    @Column(length = 11, nullable = false)
    private String ruc;

    @Column(length = 100, nullable = false)
    private String direccion;

    @Column(length = 7, nullable = false)
    private String telefono;

    @Column(length = 9, nullable = false)
    private String celular;

    @Column(length = 100, nullable = false)
    private String correo;

    //Relación con la tabla tb_distritos
    @ManyToOne
    @JoinColumn(name = "idDistrito")
    private Distrito distrito;

    //Relación con la tabla tb_tipoDocumentos
    @ManyToOne
    @JoinColumn(name = "idTipoDocumentoIdentidad")
    private TipoDocumentoIdentidad tipoDocumentoIdentidad;
}