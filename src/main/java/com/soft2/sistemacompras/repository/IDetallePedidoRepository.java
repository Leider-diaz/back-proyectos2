package com.soft2.sistemacompras.repository;

import com.soft2.sistemacompras.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetallePedidoRepository extends JpaRepository<DetallePedido, Long> {

}
