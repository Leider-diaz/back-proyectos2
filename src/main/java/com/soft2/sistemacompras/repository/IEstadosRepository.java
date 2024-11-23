package com.soft2.sistemacompras.repository;

import com.soft2.sistemacompras.model.Estados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadosRepository extends JpaRepository<Estados, Long> {
    Estados findBySigla(String sigla);
}
