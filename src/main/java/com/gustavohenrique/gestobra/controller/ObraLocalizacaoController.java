package com.gustavohenrique.gestobra.controller;

import com.gustavohenrique.gestobra.dto.request.ObraLocalizacaoRequest;
import com.gustavohenrique.gestobra.dto.response.ObraLocalizacaoResponse;
import com.gustavohenrique.gestobra.model.ObraLocalizacao;
import com.gustavohenrique.gestobra.service.ObraLocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("obralocalizacao")
public class ObraLocalizacaoController  {

    @Autowired
    private ObraLocalizacaoService service;

    @PostMapping
    public void cadastrar(@RequestBody ObraLocalizacaoRequest request) {

        service.cadastrarObraLocalizacao(request);
    }

    @GetMapping
    public List<ObraLocalizacaoResponse> listar() {

        return service.buscarObrasLocalizacoes();
    }

    @GetMapping("/{id}")
    ObraLocalizacao getObraLocalizacaoById(@PathVariable Integer id) {

        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarObraLocalizacao(@PathVariable Integer id) {

        service.deletarObraLocalizacao(id);
    }

    @PutMapping
    public ObraLocalizacaoResponse atualizarObrasLocalizacoes(@RequestBody ObraLocalizacaoRequest request, @PathVariable Integer id) {

        return service.atualizarObrasLocalizacoes(request, id);
    }
}
