package com.gustavohenrique.gestobra.dto.request;

import lombok.Data;

@Data
public class ObraInspecaoRequest {

    private Integer obraId;
    private String frequencia;
    private Integer mes;
    private String status;
    private Integer prioridade;
}
