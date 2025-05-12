package com.gustavohenrique.gestobra.dto.response;

import com.gustavohenrique.gestobra.model.Inspecao;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class InspecaoResponse {

    private Integer id;
    private Integer obraInspecaoId;
    private LocalDate data;
    private String observacoes;

    public static InspecaoResponse of(Inspecao inspecao) {

        return InspecaoResponse.builder()
                .id(inspecao.getId())
                .obraInspecaoId(inspecao.getObraInspecao().getId())
                .data(inspecao.getData())
                .observacoes(inspecao.getObservacoes())
                .build();
    }

    public static List<InspecaoResponse> of(List<Inspecao> inspecaos) {

        if (inspecaos == null) {

            return null;
        }

        List<InspecaoResponse> list = new ArrayList<>(inspecaos.size());

        for (Inspecao inspecao: inspecaos) {

            list.add(of(inspecao));
        }

        return list;
    }
}
