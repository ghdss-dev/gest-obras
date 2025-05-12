package com.gustavohenrique.gestobra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gustavohenrique.gestobra.dto.request.InspecaoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="inspecao")
public class Inspecao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "obraInspecaoId", nullable = false)
    private ObraInspecao obraInspecao;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "observacoes", length = 500)
    private String observacoes;

    public static Inspecao of(InspecaoRequest request) {

        var inspecao = new Inspecao();

        BeanUtils.copyProperties(request, inspecao);

        return inspecao;
    }

}
