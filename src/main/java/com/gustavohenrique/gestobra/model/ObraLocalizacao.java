package com.gustavohenrique.gestobra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gustavohenrique.gestobra.dto.request.ObraLocalizacaoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "obralocalizacao")
public class ObraLocalizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "cidade", length = 50)
    private String cidade;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "obraId", nullable = false)
    private Obra obra;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "latitude", length = 50)
    private Double latitude;

    @Column(name = "longitude", length = 50)
    private Double longitude;

    public ObraLocalizacao(Integer id) {

        this.id = id;
    }

    public static ObraLocalizacao of(ObraLocalizacaoRequest request) {

        var obralocalizacao = new ObraLocalizacao();
        BeanUtils.copyProperties(request, obralocalizacao);

        return obralocalizacao;
    }
}
