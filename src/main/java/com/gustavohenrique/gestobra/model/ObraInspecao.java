package com.gustavohenrique.gestobra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gustavohenrique.gestobra.dto.request.ObraInspecaoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "obrainspecao")
public class ObraInspecao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "obraId", nullable = false)
    private Obra obra;

    @Column(name = "frequencia",length = 50)
    private String frequencia;

    @Column(name = "mes", length = 2)
    private Integer mes;

    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "prioridade", length = 7)
    private Integer prioridade;

    public ObraInspecao(Integer id) {

        this.id = id;
    }

    public static ObraInspecao of(ObraInspecaoRequest request) {

        var obrainspecao = new ObraInspecao();
        BeanUtils.copyProperties(request, obrainspecao);

        return obrainspecao;
    }
}
