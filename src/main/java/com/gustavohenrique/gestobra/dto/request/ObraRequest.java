package com.gustavohenrique.gestobra.dto.request;

import lombok.Data;

@Data
public class ObraRequest {

    private String nome;
    private Integer anoconstrucao;
    private String coordenacao;
    private String gerencia;
    private String diretoria;
    private String outorga;
    private String titularidade;
}
