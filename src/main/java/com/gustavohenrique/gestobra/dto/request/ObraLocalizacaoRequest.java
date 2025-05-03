package com.gustavohenrique.gestobra.dto.request;

import lombok.Data;

@Data
public class ObraLocalizacaoRequest {

    private String cidade;
    private Integer obraId;
    private String estado;
    private Double latitude;
    private Double longitude;
}
