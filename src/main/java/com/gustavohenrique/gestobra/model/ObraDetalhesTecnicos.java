package com.gustavohenrique.gestobra.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gustavohenrique.gestobra.dto.request.ObraDetalhesTecnicosRequest;
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
@Table(name = "obra_detalhes_tecnicos")
public class ObraDetalhesTecnicos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "obraId", nullable = false)
    private Obra obra;

    @Column(name = "tipo", length = 200)
    private String tipo;

    @Column(name = "risco", length = 200)
    private String risco;

    public static ObraDetalhesTecnicos of(ObraDetalhesTecnicosRequest request) {

        var obradetalhestecnicos = new ObraDetalhesTecnicos();

        BeanUtils.copyProperties(request, obradetalhestecnicos);

        return obradetalhestecnicos;
    }
}
