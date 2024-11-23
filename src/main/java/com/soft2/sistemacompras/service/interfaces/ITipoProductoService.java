package com.soft2.sistemacompras.service.interfaces;

import com.soft2.sistemacompras.model.TipoProducto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITipoProductoService {

    List<TipoProducto> findAllTipoProducto();

}
