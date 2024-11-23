package com.soft2.sistemacompras.repository;

import com.soft2.sistemacompras.model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoProductoRepository extends JpaRepository<TipoProducto, Long> {
}
