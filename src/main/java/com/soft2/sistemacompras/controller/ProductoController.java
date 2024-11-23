package com.soft2.sistemacompras.controller;
import com.soft2.sistemacompras.model.Producto;
import com.soft2.sistemacompras.service.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/producto")
public class ProductoController {

    private IProductoService productoService;

    @GetMapping("/list")
    public ResponseEntity<List<Producto>> getProductos(){
        return new ResponseEntity<>(this.productoService.getProductos(), HttpStatus.OK);
    }

    @Autowired
    public void setProductoService(IProductoService productoService) {
        this.productoService = productoService;
    }
}
