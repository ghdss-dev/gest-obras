package com.gustavohenrique.gestobra.service;

import com.gustavohenrique.gestobra.dto.request.ObraLocalizacaoRequest;
import com.gustavohenrique.gestobra.dto.response.ObraLocalizacaoResponse;
import com.gustavohenrique.gestobra.dto.response.ObraResponse;
import com.gustavohenrique.gestobra.model.ObraLocalizacao;
import com.gustavohenrique.gestobra.repository.ObraLocalizacaoRepository;
import com.gustavohenrique.gestobra.repository.ObraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLocalizacaoService {

    @Autowired
    private ObraLocalizacaoRepository repository;

    @Autowired
    private ObraRepository obraRepository;

    public void cadastrarObraLocalizacao(ObraLocalizacaoRequest request) {
        var obra = obraRepository.findById(request.getObraId())
                .orElseThrow(() -> new RuntimeException("Obra não encontrada"));

        var obralocalizacao = ObraLocalizacao.of(request);
        obralocalizacao.setObra(obra); // 🔥 Aqui é o ponto essencial

        repository.save(obralocalizacao);
    }

    public List<ObraLocalizacaoResponse> buscarObrasLocalizacoes() {

        return ObraLocalizacaoResponse.of(repository.findAll());
    }

    public ObraLocalizacao buscarPorId(Integer id) {

        return repository.findById(id).get();
    }

    @Transactional
    public ObraLocalizacaoResponse atualizarObrasLocalizacoes(ObraLocalizacaoRequest request, Integer id) {
        var obralocalizacao = buscarPorId(id);

        // Atualiza os campos manualmente
        obralocalizacao.setCidade(request.getCidade());
        obralocalizacao.setEstado(request.getEstado());
        obralocalizacao.setLatitude(request.getLatitude());
        obralocalizacao.setLongitude(request.getLongitude());

        // Atualiza o relacionamento se for enviado
        if (request.getObraId() != null) {
            var obra = obraRepository.findById(request.getObraId())
                    .orElseThrow(() -> new RuntimeException("Obra não encontrada"));
            obralocalizacao.setObra(obra);
        }

        return ObraLocalizacaoResponse.of(repository.save(obralocalizacao));

    }


    public void deletarObraLocalizacao(Integer id) {

        var obralocalizacao = buscarPorId(id);
        repository.delete(obralocalizacao);
    }

}
