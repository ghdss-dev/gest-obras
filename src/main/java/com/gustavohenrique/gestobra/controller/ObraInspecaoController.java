package com.gustavohenrique.gestobra.controller;

import com.gustavohenrique.gestobra.dto.request.ObraInspecaoRequest;
import com.gustavohenrique.gestobra.dto.response.ObraInspecaoResponse;
import com.gustavohenrique.gestobra.model.ObraInspecao;
import com.gustavohenrique.gestobra.service.ObraInspecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("obrainspecao")
public class ObraInspecaoController {

    @Autowired
    private ObraInspecaoService service;

    @PostMapping
    public void cadastrar(@RequestBody ObraInspecaoRequest request) {

        service.cadastrarObraInspecao(request);
    }

    @GetMapping
    public List<ObraInspecaoResponse> listar() {

        return service.buscarObrasInspecoes();
    }

    @GetMapping("/{id}")
    ObraInspecao getObraInspecaoById(@PathVariable Integer id) {

        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarObraInspecao(@PathVariable Integer id) {

        service.deletarObraInspecao(id);
    }

    @PutMapping
    public ObraInspecaoResponse atualizarObrasInspecoes(@RequestBody ObraInspecaoRequest request, @PathVariable Integer id) {

        return service.atualizarObrasInspecoes(request, id);
    }
}
