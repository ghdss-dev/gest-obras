package com.gustavohenrique.gestobra.dto.response;

import com.gustavohenrique.gestobra.model.ObraDetalhesTecnicos;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class ObraDetalhesTecnicosResponse {

    private Integer id;
    private Integer obraId;
    private String tipo;
    private String risco;

    public static ObraDetalhesTecnicosResponse of(ObraDetalhesTecnicos obraDetalheTecnico) {

        return ObraDetalhesTecnicosResponse.builder()
                .id(obraDetalheTecnico.getId())
                .obraId(obraDetalheTecnico.getObra().getId())
                .tipo(obraDetalheTecnico.getTipo())
                .risco(obraDetalheTecnico.getRisco())
                .build();
    }

    public static List<ObraDetalhesTecnicosResponse> of(List<ObraDetalhesTecnicos> obts) {

        if(obts == null) {

            return  null;
        }

        List<ObraDetalhesTecnicosResponse> list = new ArrayList<>(obts.size());

        for (ObraDetalhesTecnicos obt : obts) {

           list.add(of(obt));
        }

        return list;
    }
}
