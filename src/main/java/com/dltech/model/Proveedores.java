package com.dltech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_proveedores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProv;

    @Column(length = 60, nullable = false)
    private String nomProv;

    @Column(length = 80, nullable = false)
    private String razonSocial;

    @Column(length = 11, nullable = false)
    private String ruc;

    @Column(length = 12, nullable = false)
    private String telefono;

    @Column(length = 12, nullable = false)
    private String celular;

    @Column(length = 200, nullable = false)
    private String correo;
}
