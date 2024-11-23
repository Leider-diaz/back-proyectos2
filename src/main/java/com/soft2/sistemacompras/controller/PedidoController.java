package com.soft2.sistemacompras.controller;

import com.soft2.sistemacompras.model.Pedido;
import com.soft2.sistemacompras.service.interfaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/pedido")
public class PedidoController {
    private IPedidoService pedidoService;
    @PostMapping("/realizarPedido")
    public ResponseEntity<Pedido> realizarPedido(@RequestParam(value = "idUsuario") Long idUsuario,
                                                 @RequestParam(value = "idProducto") Long idProducto,
                                                 @RequestParam(value = "cantidad") Long cantidad){
        return new ResponseEntity<>(pedidoService.realizarPedido(idUsuario,idProducto, cantidad), HttpStatus.OK);
    }

    @PostMapping("/realizarPedidoCarrito")
    public ResponseEntity<Pedido> realizarPedidoCarrito(@RequestParam(value = "idUsuario") Long idUsuario){
        return new ResponseEntity<>(pedidoService.realizarPedidoCarrito(idUsuario), HttpStatus.OK);
    }

    @Autowired
    public void setPedidoService(IPedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
}
