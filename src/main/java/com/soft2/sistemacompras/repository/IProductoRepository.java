package com.soft2.sistemacompras.repository;

import com.soft2.sistemacompras.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

    @Query("select p from Producto p where p.cantidad > 0")
    List<Producto> findAllProductos();
}
