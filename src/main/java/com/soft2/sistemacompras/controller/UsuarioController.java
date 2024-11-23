package com.soft2.sistemacompras.controller;

import com.soft2.sistemacompras.model.Usuario;
import com.soft2.sistemacompras.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuario")
public class UsuarioController {

    private IUsuarioService usuarioService;

    @GetMapping("/validarUsuario")
    public ResponseEntity<Usuario> validaUsuario(@RequestParam(value = "username")String username,
                                                 @RequestParam(value = "password")String password){
        return new ResponseEntity<>(this.usuarioService.validateUser(username, password), HttpStatus.OK);
    }

    @Autowired
    public void setUsuarioService(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
