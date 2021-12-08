package com.example.accessingdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // isto significa que é uma classe de um controlador
@RequestMapping(path = "/demo") // isto significa que os caminhos do demo

public class PrincipalController {
    @Autowired // faz o start do objeto
    private usuarioRepository uRepository;

    // @PostMapping
    // @GetMapping
    // @PutMapping
    // @DeleteMapping

    @PostMapping(path = "/add")
    public @ResponseBody String addNovoUsuario(@RequestParam String nome, @RequestParam String email) {
      
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        uRepository.save(u);
        return "ok gravado";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Usuario> getAllusuario() {
        return uRepository.findAll();
    }
}
