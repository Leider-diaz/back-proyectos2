package com.soft2.sistemacompras.service.interfaces;

import com.soft2.sistemacompras.model.Pedido;
import org.springframework.stereotype.Service;

@Service
public interface IPedidoService {

    Pedido realizarPedido(Long idUsuario, Long idProducto, Long cantidad);

    Pedido realizarPedidoCarrito(Long idUsuario);
}
