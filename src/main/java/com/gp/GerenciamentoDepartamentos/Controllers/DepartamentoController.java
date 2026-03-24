package com.gp.GerenciamentoDepartamentos.Controllers;

import com.gp.GerenciamentoDepartamentos.Models.DepartamentoModel;
import com.gp.GerenciamentoDepartamentos.Repositories.DepartamentoRepository;
import com.gp.GerenciamentoDepartamentos.Services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<DepartamentoModel> salvarDepartamento(@RequestBody DepartamentoModel departamentoModel) {
        DepartamentoModel request =  departamentoService.salvarDepartamento(departamentoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(departamentoModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> listarDepartamentos() {
        List<DepartamentoModel> request = departamentoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoModel> buscarDepartamento(@PathVariable Long id) {
        DepartamentoModel request = departamentoService.findById(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDepartamento(@PathVariable Long id) {
        departamentoService.deletarDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}
