package com.soft2.sistemacompras.service.interfaces;

import com.soft2.sistemacompras.model.ProductosCarrito;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductosCarritoService {

    void addProducto(Long idProducto, Long cantidad, Long idUsuario);

    List<ProductosCarrito> getProductosCarrito(Long idUsuario);

    void deleteProductoCarrito(Long idProductoCarrito);
}
