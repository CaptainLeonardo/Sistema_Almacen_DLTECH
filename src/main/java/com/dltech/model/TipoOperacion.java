package com.dltech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_tipoOperacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoOperacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoOperacion;

    @Column(length = 100, nullable = false)
    private String tipoOperacion;
}
