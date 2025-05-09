package com.gustavohenrique.gestobra.controller;

import com.gustavohenrique.gestobra.dto.request.ObraRequest;
import com.gustavohenrique.gestobra.dto.response.ObraResponse;
import com.gustavohenrique.gestobra.model.Obra;
import com.gustavohenrique.gestobra.repository.ObraRepository;
import com.gustavohenrique.gestobra.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("obra")
public class ObraController {

    @Autowired
    private ObraService service;

    @Autowired
    private ObraRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody ObraRequest request) {

        service.cadastrarObra(request);
    }

    @GetMapping
    public List<ObraResponse> listar() {

        return service.buscarObras();
    }

    @GetMapping("/{id}")
    Obra getObraById(@PathVariable Integer id) {

        return service.buscarPorid(id);
    }

    @PutMapping("/{id}")
    public ObraResponse atualizarObra(@RequestBody ObraRequest request, @PathVariable Integer id) {
        return service.updateObra(request, id);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id) {
        service.removeObra(id);
    }
}
