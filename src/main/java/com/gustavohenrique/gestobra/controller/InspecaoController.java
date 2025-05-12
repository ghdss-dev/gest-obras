package com.gustavohenrique.gestobra.controller;

import com.gustavohenrique.gestobra.dto.request.InspecaoRequest;
import com.gustavohenrique.gestobra.dto.response.InspecaoResponse;
import com.gustavohenrique.gestobra.model.Inspecao;
import com.gustavohenrique.gestobra.service.InspecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inspecao")
public class InspecaoController {

    @Autowired
    private InspecaoService service;

    @PostMapping
    public void cadastrar(@RequestBody InspecaoRequest request) {

        service.cadastrarInspecao(request);
    }

    @GetMapping
    public List<InspecaoResponse> listar() {

        return service.buscarInspecoes();
    }

    @GetMapping("{id}")
    Inspecao getInspecaoById(@PathVariable Integer id) {

        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public InspecaoResponse atualizarInspecao(@RequestBody InspecaoRequest request, @PathVariable Integer id) {

        return service.atualizarInspecoes(request, id);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id) {
        service.removeInspecao(id);
    }
}
