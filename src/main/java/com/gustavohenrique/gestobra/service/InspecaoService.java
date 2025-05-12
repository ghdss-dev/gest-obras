package com.gustavohenrique.gestobra.service;

import com.gustavohenrique.gestobra.dto.request.InspecaoRequest;
import com.gustavohenrique.gestobra.dto.response.InspecaoResponse;
import com.gustavohenrique.gestobra.model.Inspecao;
import com.gustavohenrique.gestobra.repository.InspecaoRepository;
import com.gustavohenrique.gestobra.repository.ObraInspecaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspecaoService {

    @Autowired
    private InspecaoRepository repository;

    @Autowired
    private ObraInspecaoRepository obraInspecaoRepository;

    public void cadastrarInspecao(InspecaoRequest request) {

        var obraInspecao =  obraInspecaoRepository.findById(request.getObraInspecaoId())
                .orElseThrow(() -> new RuntimeException("Inspeção não encontrado"));

        var inspecao = Inspecao.of(request);

        inspecao.setObraInspecao(obraInspecao);

        repository.save(inspecao);
    }

    public List<InspecaoResponse> buscarInspecoes() {

        return InspecaoResponse.of(repository.findAll());
    }

    public Inspecao buscarPorId(Integer id) {

        return repository.findById(id).get();
    }

    @Transactional
    public InspecaoResponse atualizarInspecoes(InspecaoRequest request, Integer id) {

        var inspecao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inspeção não encontrado"));

        var obrasinspecoes = inspecao.getObraInspecao();

        BeanUtils.copyProperties(Inspecao.of(request), inspecao, "id", "obrasinspecoes");

        inspecao.setObraInspecao(obrasinspecoes);

        return InspecaoResponse.of(repository.save(inspecao));
    }

    public void removeInspecao (Integer id) {

        var inspecao = buscarPorId(id);
        repository.delete(inspecao);
    }
}
