package com.gustavohenrique.gestobra.repository;

import com.gustavohenrique.gestobra.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Integer> {
}
