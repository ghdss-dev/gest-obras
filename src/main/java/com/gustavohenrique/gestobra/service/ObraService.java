package com.gustavohenrique.gestobra.service;

import com.gustavohenrique.gestobra.dto.request.ObraRequest;
import com.gustavohenrique.gestobra.dto.response.ObraResponse;
import com.gustavohenrique.gestobra.model.Obra;
import com.gustavohenrique.gestobra.repository.ObraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {

    @Autowired
    private ObraRepository repository;

    public void cadastrarObra (ObraRequest request) {

        repository.save(Obra.of(request));
    }

    public List<ObraResponse> buscarObras() {

        return ObraResponse.of(repository.findAll());
    }

    public Obra buscarPorid(Integer id) {

        return repository.findById(id).get();
    }

    @Transactional
    public ObraResponse updateObra(ObraRequest request, Integer id) {
        var obra = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Obra não encontrada"));

        var localizacoes = obra.getLocalizacoes();
        var detalhesTecnicos = obra.getObraDetalhesTecnicos();

        BeanUtils.copyProperties(Obra.of(request), obra, "id", "localizacoes", "obraDetalhesTecnicos");

        obra.setLocalizacoes(localizacoes);
        obra.setObraDetalhesTecnicos(detalhesTecnicos);

        return ObraResponse.of(repository.save(obra));
    }

    public void removeObra(Integer id) {

        var obra = buscarPorid(id);
        repository.delete(obra);
    }
}
