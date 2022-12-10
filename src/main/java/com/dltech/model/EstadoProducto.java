package com.dltech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_estadoproducto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstadoP;

    @Column(length = 60, nullable = false)
    private String nomEstadoP;
}
