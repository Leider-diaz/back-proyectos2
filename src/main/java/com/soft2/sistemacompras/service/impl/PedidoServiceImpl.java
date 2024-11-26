package com.soft2.sistemacompras.service.impl;

import com.soft2.sistemacompras.dto.PedidoDTO;
import com.soft2.sistemacompras.dto.ProductoDTO;
import com.soft2.sistemacompras.model.DetallePedido;
import com.soft2.sistemacompras.model.Pedido;
import com.soft2.sistemacompras.model.ProductosCarrito;
import com.soft2.sistemacompras.repository.*;
import com.soft2.sistemacompras.service.interfaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PedidoServiceImpl implements IPedidoService {

    private IProductoRepository productoRepository;
    private IPedidoRepository pedidoRepository;
    private IDetallePedidoRepository detallePedidoRepository;
    private IEstadosRepository estadosRepository;
    private IProductosCarritoRepository productosCarritoRepository;

    @Override
    public Pedido realizarPedido(Long idUsuario, Long idProducto, Long cantidad){
        if(cantidad == 0L){
            throw new RuntimeException("La cantidad de productos a incluir no puede ser 0");
        }
        var producto = this.productoRepository.findById(idProducto).orElse(null);
        var estado = this.estadosRepository.findBySigla("R");
        var pedido = new Pedido();
        var detallePedido = new DetallePedido();
        if(producto == null){
            throw new RuntimeException("Producto no encontrado");
        }
        if(producto.getCantidad() < cantidad){
            throw new RuntimeException("No hay disponibilidad para esa cantidad de producto");
        }

        pedido.setIdEstado(estado.getId());
        pedido.setIdUsuario(idUsuario);
        pedido.setFecha(new Date());
        pedido.setTienda("3B");
        var pedidoSave = this.pedidoRepository.save(pedido);

        detallePedido.setIdPedido(pedidoSave.getId());
        detallePedido.setIdProducto(idProducto);
        detallePedido.setCantidad(cantidad);

        var detalleSave = this.detallePedidoRepository.save(detallePedido);

        producto.setCantidad(producto.getCantidad() - detalleSave.getCantidad());

        this.productoRepository.save(producto);

        return pedido;
    }

    @Override
    public Pedido realizarPedidoCarrito(Long idUsuario){
        var productosCarrito = this.productosCarritoRepository.findAllByIdUsuario(idUsuario);
        var pedido = new Pedido();
        var estado = this.estadosRepository.findBySigla("R");

        pedido.setIdEstado(estado.getId());
        pedido.setIdUsuario(idUsuario);
        var pedidoSave = this.pedidoRepository.save(pedido);

        for (ProductosCarrito productoCarrito: productosCarrito){
            var producto = this.productoRepository.findById(productoCarrito.getIdProducto()).orElse(null);
            var detallePedido = new DetallePedido();

            if(producto == null){
                throw new RuntimeException("Producto no encontrado");
            }
            if(producto.getCantidad() < productoCarrito.getCantidad()){
                throw new RuntimeException("No hay disponibilidad para esa cantidad de producto");
            }

            detallePedido.setIdPedido(pedidoSave.getId());
            detallePedido.setIdProducto(productoCarrito.getIdProducto());
            detallePedido.setCantidad(productoCarrito.getCantidad());

            var detalleSave = this.detallePedidoRepository.save(detallePedido);

            producto.setCantidad(producto.getCantidad() - detalleSave.getCantidad());

            this.productoRepository.save(producto);
        }

        this.productosCarritoRepository.deleteAll(productosCarrito);
        return pedido;
    }

    @Override
    public List<PedidoDTO> getPedidoDTO(){
        List<PedidoDTO> pedidosDTO = new ArrayList<>();
        var pedidosBD = this.pedidoRepository.findAll();

        for (Pedido pedido: pedidosBD){
            PedidoDTO pedidoDTO = new PedidoDTO();
            pedidoDTO.setId(pedido.getId());
            pedidoDTO.setStatus(pedido.getEstados().getNombre());
            pedidoDTO.setDate(pedido.getFecha());
            pedidoDTO.setStore(pedido.getTienda());
            pedidoDTO.setCostumer_name(pedido.getUsuario().getNombre() + ' ' + pedido.getUsuario().getApellido());
            BigDecimal total = new BigDecimal(0);
            List<ProductoDTO> productoDTOList = new ArrayList<>();
            for (DetallePedido detallePedido : pedido.getDetallePedidoList()){
                ProductoDTO productoDTO = new ProductoDTO();
                productoDTO.setPrice(detallePedido.getProducto().getPrecio());
                productoDTO.setQuantity(detallePedido.getCantidad());
                productoDTO.setProduct_name(detallePedido.getProducto().getNombre());
                total = total.add(detallePedido.getProducto().getPrecio());
                productoDTOList.add(productoDTO);
            }
            pedidoDTO.setTotal_price(total);
            pedidoDTO.setProducts(productoDTOList);
            pedidosDTO.add(pedidoDTO);
        }
        return pedidosDTO;
    }

    @Autowired
    public void setProductosCarritoRepository(IProductosCarritoRepository productosCarritoRepository) {
        this.productosCarritoRepository = productosCarritoRepository;
    }

    @Autowired
    public void setProductoRepository(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Autowired
    public void setDetallePedidoRepository(IDetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @Autowired
    public void setEstadosRepository(IEstadosRepository estadosRepository) {
        this.estadosRepository = estadosRepository;
    }

    @Autowired
    public void setPedidoRepository(IPedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
}
