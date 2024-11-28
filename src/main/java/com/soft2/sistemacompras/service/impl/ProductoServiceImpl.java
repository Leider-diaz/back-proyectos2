package com.soft2.sistemacompras.service.impl;

import com.soft2.sistemacompras.model.Producto;
import com.soft2.sistemacompras.repository.IProductoRepository;
import com.soft2.sistemacompras.service.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos(){
        var productos = productoRepository.findAllProductos();
        return productos;
    }

    @Autowired
    public void setProductoRepository(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
}
