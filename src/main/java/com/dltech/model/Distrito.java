package com.dltech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_distritos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Distrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDistrito;

    @Column(length = 50, nullable = false)
    private String distrito;

    @Column(length = 6, nullable = false)
    private String ubigeo;
}
