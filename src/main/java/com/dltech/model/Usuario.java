package com.dltech.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(length = 100, nullable = false)
    private String nomApe;
    @Column(length = 12, nullable = false,unique = true)
    private String usuario;
    @Column(length = 11, nullable = false)
    private String clave;
    @Column(length = 7, nullable = false)
    private String bContraseña;

}
