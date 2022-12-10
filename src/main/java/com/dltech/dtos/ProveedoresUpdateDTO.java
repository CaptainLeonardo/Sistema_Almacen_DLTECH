package com.dltech.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProveedoresUpdateDTO {
    private Integer idProv;
    private String nomProv;
    private String razonSocial;
    private String ruc;
    private String telefono;
    private String celular;
    private String correo;
}
