package com.gustavohenrique.gestobra.model;

import com.gustavohenrique.gestobra.dto.request.ObraRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="obra")
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", length = 45)
    private String nome;

    @Column(name = "anoconstrucao", length = 50)
    private Integer anoconstrucao;

    @Column(name = "coordenacao", length = 45)
    private String coordenacao;

    @Column(name = "gerencia", length = 45)
    private String gerencia;

    @Column(name = "diretoria", length = 45)
    private String diretoria;

    @Column(name = "outorga", length = 45)
    private String outorga;

    @Column(name = "titularidade", length = 45)
    private String titularidade;

    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObraLocalizacao> localizacoes = new ArrayList<>();

    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObraDetalhesTecnicos> obraDetalhesTecnicos = new ArrayList<>();

    public static Obra of(ObraRequest request) {

        var obra = new Obra();

        BeanUtils.copyProperties(request, obra);

        return  obra;
    }

}
