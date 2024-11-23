package com.soft2.sistemacompras.repository;

import com.soft2.sistemacompras.model.ProductosCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductosCarritoRepository extends JpaRepository<ProductosCarrito, Long> {
    List<ProductosCarrito> findAllByIdUsuario(Long idUsuario);


    Optional<ProductosCarrito> findByIdUsuarioAndIdProducto(Long idUsuario, Long idProducto);
}
