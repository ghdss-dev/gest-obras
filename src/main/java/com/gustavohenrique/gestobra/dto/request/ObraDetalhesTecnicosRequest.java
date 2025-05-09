package com.gustavohenrique.gestobra.dto.request;

import lombok.Data;

@Data
public class ObraDetalhesTecnicosRequest {

    private Integer obraId;
    private String tipo;
    private String risco;
}
