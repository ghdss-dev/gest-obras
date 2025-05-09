package com.gustavohenrique.gestobra.service;

import com.gustavohenrique.gestobra.dto.request.ObraDetalhesTecnicosRequest;
import com.gustavohenrique.gestobra.dto.response.ObraDetalhesTecnicosResponse;
import com.gustavohenrique.gestobra.model.ObraDetalhesTecnicos;
import com.gustavohenrique.gestobra.repository.ObraDetalhesTecnicosRepository;
import com.gustavohenrique.gestobra.repository.ObraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObrasDetalhesTecnicosService {

    @Autowired
    private ObraDetalhesTecnicosRepository repository;

    @Autowired
    private ObraRepository obraRepository;

    public void cadastrarObdt(ObraDetalhesTecnicosRequest request) {

        var obra = obraRepository.findById(request.getObraId())
                .orElseThrow(() -> new RuntimeException("Obra não encontrada"));

        var obradetalhestecnicos = ObraDetalhesTecnicos.of(request);
        obradetalhestecnicos.setObra(obra);

        repository.save(obradetalhestecnicos);
    }

    public List<ObraDetalhesTecnicosResponse> buscarObrasDetalhesTecnicos() {

        return ObraDetalhesTecnicosResponse.of(repository.findAll());
    }

    public ObraDetalhesTecnicos buscarPorId(Integer id) {

        return repository.findById(id).get();
    }

    @Transactional
    public ObraDetalhesTecnicosResponse atualizarObrasDetalheTecnico(ObraDetalhesTecnicosRequest request, Integer id) {

        var obraDetalheTecnico = buscarPorId(id);

        // Atualiza os campos manualmente
        obraDetalheTecnico.setRisco(request.getRisco());
        obraDetalheTecnico.setTipo(request.getTipo());

        // Atualiza o relacionamento se for enviado
        if (request.getObraId() != null) {
            var obra = obraRepository.findById(request.getObraId())
                    .orElseThrow(() -> new RuntimeException("Obra não encontrada"));
            obraDetalheTecnico.setObra(obra);
        }

        return ObraDetalhesTecnicosResponse.of(repository.save(obraDetalheTecnico));
    }

    public void deletarObraDetalheTecnico(Integer id) {

        var obradetalhetecnico = buscarPorId(id);
        repository.delete(obradetalhetecnico);
    }
}
