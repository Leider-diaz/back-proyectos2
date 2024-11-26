package com.soft2.sistemacompras.controller;
import com.soft2.sistemacompras.model.ProductosCarrito;
import com.soft2.sistemacompras.service.interfaces.IProductosCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/productosCarrito")
public class ProductosCarritoController {

    private IProductosCarritoService productosCarritoService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductosCarrito>> getProductosCarrito(@RequestParam(value = "idUsuario") Long idUsuario){
        return new ResponseEntity<>(this.productosCarritoService.getProductosCarrito(idUsuario), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> addProductosCarrito(@RequestParam(value = "idUsuario") Long idUsuario,
                                                                @RequestParam(value = "idProducto") Long idProducto,
                                                                @RequestParam(value = "cantidad") Long cantidad){
        this.productosCarritoService.addProducto(idProducto,cantidad,idUsuario);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping("/addUn")
    public ResponseEntity<Boolean> addUnProductoCarrito(@RequestParam(value = "idUsuario") Long idUsuario,
                                                       @RequestParam(value = "idProducto") Long idProducto){
        this.productosCarritoService.addUnProducto(idProducto,idUsuario);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping("/deleteUn")
    public ResponseEntity<Boolean> deleteUnProductoCarrito(@RequestParam(value = "idUsuario") Long idUsuario,
                                                        @RequestParam(value = "idProducto") Long idProducto){
        this.productosCarritoService.deleteUnProducto(idProducto,idUsuario);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idProductoCarrito}")
    public ResponseEntity<Boolean> deleteProductosCarrito(@PathVariable(value = "idProductoCarrito") Long idProductoCarrito){
        this.productosCarritoService.deleteProductoCarrito(idProductoCarrito);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @Autowired
    public void setProductosCarritoService(IProductosCarritoService productosCarritoService) {
        this.productosCarritoService = productosCarritoService;
    }
}
