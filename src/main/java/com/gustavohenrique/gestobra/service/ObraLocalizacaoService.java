package com.gustavohenrique.gestobra.service;

import com.gustavohenrique.gestobra.dto.request.ObraLocalizacaoRequest;
import com.gustavohenrique.gestobra.dto.response.ObraLocalizacaoResponse;
import com.gustavohenrique.gestobra.dto.response.ObraResponse;
import com.gustavohenrique.gestobra.model.ObraLocalizacao;
import com.gustavohenrique.gestobra.repository.ObraLocalizacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLocalizacaoService {

    @Autowired
    private ObraLocalizacaoRepository repository;

    public void cadastrarObraLocalizacao(ObraLocalizacaoRequest request) {

        repository.save(ObraLocalizacao.of(request));
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
        BeanUtils.copyProperties(ObraLocalizacao.of(request), obralocalizacao, "id");

        return ObraLocalizacaoResponse.of(repository.save(obralocalizacao));
    }

    public void deletarObraLocalizacao(Integer id) {

        var obralocalizacao = buscarPorId(id);
        repository.delete(obralocalizacao);
    }

}
