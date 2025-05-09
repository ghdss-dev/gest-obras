package com.gustavohenrique.gestobra.service;

import com.gustavohenrique.gestobra.dto.request.ObraInspecaoRequest;
import com.gustavohenrique.gestobra.dto.response.ObraInspecaoResponse;
import com.gustavohenrique.gestobra.model.ObraInspecao;
import com.gustavohenrique.gestobra.repository.ObraInspecaoRepository;
import com.gustavohenrique.gestobra.repository.ObraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraInspecaoService {

    @Autowired
    private ObraInspecaoRepository repository;

    @Autowired
    private ObraRepository obraRepository;

    public void cadastrarObraInspecao(ObraInspecaoRequest request) {

        var obra = obraRepository.findById(request.getObraId())
                .orElseThrow(() -> new RuntimeException("Obra não encontrada"));

        var obrainspecao = ObraInspecao.of(request);
        obrainspecao.setObra(obra);

        repository.save(obrainspecao);
    }

    public List<ObraInspecaoResponse> buscarObrasInspecoes() {

        return ObraInspecaoResponse.of(repository.findAll());
    }

    public ObraInspecao buscarPorId(Integer id) {

        return repository.findById(id).get();
    }

    @Transactional
    public ObraInspecaoResponse atualizarObrasInspecoes(ObraInspecaoRequest request, Integer id) {

        var obrainspecao = buscarPorId(id);

        // atualiza os campos manualmente
        obrainspecao.setFrequencia(request.getFrequencia());
        obrainspecao.setMes(request.getMes());
        obrainspecao.setStatus(request.getStatus());
        obrainspecao.setPrioridade(request.getPrioridade());

        // atualiza o relacionamento se for enviado
        if (request.getObraId() != null) {

            var obra = obraRepository.findById(request.getObraId())
                    .orElseThrow(() -> new RuntimeException("Obra não encontrada"));

            obrainspecao.setObra(obra);
        }

        return ObraInspecaoResponse.of(repository.save(obrainspecao));
    }

    public void deletarObraInspecao(Integer id) {

        var obrainspecao = buscarPorId(id);
        repository.delete(obrainspecao);
    }

}
