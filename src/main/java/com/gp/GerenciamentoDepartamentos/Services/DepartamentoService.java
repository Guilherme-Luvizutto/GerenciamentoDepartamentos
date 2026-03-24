package com.gp.GerenciamentoDepartamentos.Services;

import com.gp.GerenciamentoDepartamentos.Models.DepartamentoModel;
import com.gp.GerenciamentoDepartamentos.Repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public DepartamentoModel salvarDepartamento(DepartamentoModel departamentoModel) {
        return departamentoRepository.save(departamentoModel);
    }

    public List<DepartamentoModel> findAll() {
        return departamentoRepository.findAll();
    }

    public DepartamentoModel findById(Long id) {
        return departamentoRepository.findById(id).get();
    }

    public void deletarDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }
}
