package com.soft2.sistemacompras.service.interfaces;

import com.soft2.sistemacompras.dto.PedidoDTO;
import com.soft2.sistemacompras.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPedidoService {

    Pedido realizarPedido(Long idUsuario, Long idProducto, Long cantidad);

    Pedido realizarPedidoCarrito(Long idUsuario);

    List<PedidoDTO> getPedidoDTO();
}
