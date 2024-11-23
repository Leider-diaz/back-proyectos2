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
