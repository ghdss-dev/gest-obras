package com.gustavohenrique.gestobra.repository;

import com.gustavohenrique.gestobra.model.Inspecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspecaoRepository  extends JpaRepository<Inspecao, Integer> {
}
