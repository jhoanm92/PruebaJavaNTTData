package com.client.dto;

import com.client.model.TipoDocumentoEntity;
import lombok.Data;

@Data
public class PersonaDTO {

    public Integer id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer documento;
    private TipoDocumentoEntity tipoDocumento;
    private String telefono;
    private String direccion;
    private String ciudad;
}
