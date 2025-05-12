package com.gustavohenrique.gestobra.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InspecaoRequest {

    private Integer obraInspecaoId;
    private LocalDate data;
    private String observacoes;
}
