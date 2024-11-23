package com.soft2.sistemacompras.service.impl;

import com.soft2.sistemacompras.model.Usuario;
import com.soft2.sistemacompras.repository.IUsuarioRepository;
import com.soft2.sistemacompras.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private IUsuarioRepository usuarioRepository;

    @Override
    public Usuario validateUser(String username, String password){
        return this.usuarioRepository.findUserByUsernameAndPassword(username, password);
    }

    @Autowired
    public void setUsuarioRepository(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
