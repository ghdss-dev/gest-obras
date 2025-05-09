package com.gustavohenrique.gestobra.dto.response;

import com.gustavohenrique.gestobra.model.ObraInspecao;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class ObraInspecaoResponse {

    private Integer id;
    private Integer obraId;
    private String frequencia;
    private Integer mes;
    private String status;
    private Integer prioridade;

    public static ObraInspecaoResponse of(ObraInspecao obraInspecao) {

        return ObraInspecaoResponse.builder()
                .id(obraInspecao.getId())
                .obraId(obraInspecao.getObra().getId())
                .frequencia(obraInspecao.getFrequencia())
                .mes(obraInspecao.getMes())
                .status(obraInspecao.getStatus())
                .prioridade(obraInspecao.getPrioridade())
                .build();
    }

    public static List<ObraInspecaoResponse> of(List<ObraInspecao> obraInspecaos) {

        if(obraInspecaos == null) {

            return null;
        }

        List<ObraInspecaoResponse> list = new ArrayList<>(obraInspecaos.size());

        for (ObraInspecao obraInspecao : obraInspecaos) {

            list.add(of(obraInspecao));
        }

        return list;
    }
}
