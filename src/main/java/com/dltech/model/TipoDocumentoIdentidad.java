package com.dltech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipoDocumentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumentoIdentidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoDocumentoIdentidad;

    @Column(length = 50, nullable = false)
    private String desTipoDocumento;

}
