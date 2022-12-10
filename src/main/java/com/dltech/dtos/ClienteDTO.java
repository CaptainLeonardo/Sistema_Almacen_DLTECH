package com.dltech.dtos;

import com.dltech.model.Distrito;
import com.dltech.model.TipoDocumentoIdentidad;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    private Long idCliente;
    private String nomApe;
    private String docIdent;
    private String ruc;
    private String direccion;
    private String telefono;
    private String celular;
    private String correo;
    private Distrito distrito;
    private TipoDocumentoIdentidad tipoDocumentoIdentidad;
}
