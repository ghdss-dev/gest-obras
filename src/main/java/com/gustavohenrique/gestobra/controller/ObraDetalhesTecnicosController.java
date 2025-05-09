package com.gustavohenrique.gestobra.controller;

import com.gustavohenrique.gestobra.dto.request.ObraDetalhesTecnicosRequest;
import com.gustavohenrique.gestobra.dto.response.ObraDetalhesTecnicosResponse;
import com.gustavohenrique.gestobra.model.ObraDetalhesTecnicos;
import com.gustavohenrique.gestobra.service.ObrasDetalhesTecnicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("obrasdetalhestecnicos")
public class ObraDetalhesTecnicosController {

    @Autowired
    private ObrasDetalhesTecnicosService service;

    @PostMapping
    public void cadastrar(@RequestBody ObraDetalhesTecnicosRequest request) {

        service.cadastrarObdt(request);
    }

    @GetMapping
    public List<ObraDetalhesTecnicosResponse> listar() {

        return service.buscarObrasDetalhesTecnicos();
    }

    @GetMapping("{id}")
    ObraDetalhesTecnicos getObraDetalheTecnicoById(@PathVariable Integer id) {

        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarObraDetalheTecnico(@PathVariable Integer id) {

        service.deletarObraDetalheTecnico(id);
    }

    @PutMapping("/{id}")
    public ObraDetalhesTecnicosResponse atualizarObraDetalheTecnico(@RequestBody ObraDetalhesTecnicosRequest request, @PathVariable Integer id) {

        return service.atualizarObrasDetalheTecnico(request, id);
    }
}
