package com.soft2.sistemacompras.service.impl;

import com.soft2.sistemacompras.model.ProductosCarrito;
import com.soft2.sistemacompras.repository.IProductosCarritoRepository;
import com.soft2.sistemacompras.service.interfaces.IProductosCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosCarritoServiceImpl implements IProductosCarritoService {

    private IProductosCarritoRepository productosCarritoRepository;
    @Override
    public void addProducto(Long idProducto, Long cantidad, Long idUsuario){
        if(cantidad == 0L){
            throw new RuntimeException("La cantidad de productos a incluir no puede ser 0");
        }
        var productoExist = productosCarritoRepository.findByIdUsuarioAndIdProducto(idUsuario, idProducto).orElse(null);
        if (productoExist == null) {
            var productoCarrito = new ProductosCarrito();
            productoCarrito.setIdProducto(idProducto);
            productoCarrito.setCantidad(cantidad);
            productoCarrito.setIdUsuario(idUsuario);
            this.productosCarritoRepository.save(productoCarrito);
        } else {
            productoExist.setCantidad(productoExist.getCantidad() + cantidad);
            productosCarritoRepository.save(productoExist);
        }
    }

    @Override
    public void addUnProducto(Long idProducto, Long idUsuario){
        var productoExist = productosCarritoRepository.findByIdUsuarioAndIdProducto(idUsuario, idProducto).orElse(null);
        productoExist.setCantidad(productoExist.getCantidad() + 1L);
        productosCarritoRepository.save(productoExist);
    }

    @Override
    public void deleteUnProducto(Long idProducto, Long idUsuario){
        var productoExist = productosCarritoRepository.findByIdUsuarioAndIdProducto(idUsuario, idProducto).orElse(null);
        var cantidadModificado = productoExist.getCantidad() - 1L;
        if(cantidadModificado == 0L){
            productosCarritoRepository.delete(productoExist);
        } else {
            productoExist.setCantidad(productoExist.getCantidad() - 1L);
            productosCarritoRepository.save(productoExist);
        }

    }

    @Override
    public List<ProductosCarrito> getProductosCarrito(Long idUsuario){
        return this.productosCarritoRepository.findAllByIdUsuario(idUsuario);
    }

    @Override
    public void deleteProductoCarrito(Long idProductoCarrito){
        this.productosCarritoRepository.deleteById(idProductoCarrito);
    }

    @Autowired
    public void setProductosCarritoRepository(IProductosCarritoRepository productosCarritoRepository) {
        this.productosCarritoRepository = productosCarritoRepository;
    }
}
