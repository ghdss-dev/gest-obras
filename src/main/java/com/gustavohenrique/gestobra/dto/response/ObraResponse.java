package com.gustavohenrique.gestobra.dto.response;

import com.gustavohenrique.gestobra.model.Obra;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class ObraResponse {

    private Integer id;
    private String nome;
    private Integer anoconstrucao;
    private String coordenacao;
    private String gerencia;
    private String diretoria;
    private String outorga;
    private String titularidade;

    public static ObraResponse of(Obra obra) {

        return ObraResponse.builder()
                .id(obra.getId())
                .nome(obra.getNome())
                .anoconstrucao(obra.getAnoconstrucao())
                .coordenacao(obra.getCoordenacao())
                .gerencia(obra.getGerencia())
                .diretoria(obra.getDiretoria())
                .outorga(obra.getOutorga())
                .titularidade(obra.getTitularidade())
                .build();
    }

    public static List<ObraResponse> of(List<Obra> obras) {

        if (obras == null) {

            return null;
        }

        List<ObraResponse> list = new ArrayList<>(obras.size());

        for (Obra obra: obras) {

            list.add(of (obra));
        }

        return list;
    }
}
