package com.gp.GerenciamentoDepartamentos.Repositories;

import com.gp.GerenciamentoDepartamentos.Models.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<DepartamentoModel, Long> {
}
