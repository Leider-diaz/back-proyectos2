package com.soft2.sistemacompras.service.impl;

import com.soft2.sistemacompras.model.TipoProducto;
import com.soft2.sistemacompras.repository.ITipoProductoRepository;
import com.soft2.sistemacompras.service.interfaces.ITipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoServiceImpl implements ITipoProductoService {

    private ITipoProductoRepository tipoProductoRepository;

    public List<TipoProducto> findAllTipoProducto(){
        return this.tipoProductoRepository.findAll();
    }

    @Autowired
    public void setTipoProductoRepository(ITipoProductoRepository tipoProductoRepository) {
        this.tipoProductoRepository = tipoProductoRepository;
    }
}
