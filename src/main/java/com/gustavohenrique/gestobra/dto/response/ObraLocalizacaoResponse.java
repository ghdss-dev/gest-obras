package com.gustavohenrique.gestobra.dto.response;

import com.gustavohenrique.gestobra.model.ObraLocalizacao;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class ObraLocalizacaoResponse {

    private Integer id;
    private String cidade;
    private Integer obraId;
    private String estado;
    private Double latitude;
    private Double longitude;

    public static ObraLocalizacaoResponse of(ObraLocalizacao obraLocalizacao) {

        return ObraLocalizacaoResponse.builder()
                .id(obraLocalizacao.getId())
                .cidade(obraLocalizacao.getCidade())
                .obraId(obraLocalizacao.getObra().getId())
                .estado(obraLocalizacao.getEstado())
                .latitude(obraLocalizacao.getLatitude())
                .longitude(obraLocalizacao.getLongitude())
                .build();
    }

    public static List<ObraLocalizacaoResponse> of(List<ObraLocalizacao> obraLocalizacaos) {

        if (obraLocalizacaos == null) {

            return null;
        }

        List<ObraLocalizacaoResponse> list = new ArrayList<>(obraLocalizacaos.size());

        for (ObraLocalizacao obraLocalizacao: obraLocalizacaos) {

            list.add(of(obraLocalizacao));
        }

        return list;
    }
}
