package com.soft2.sistemacompras.service.interfaces;

import com.soft2.sistemacompras.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface IUsuarioService {

    Usuario validateUser(String username, String password);
}
