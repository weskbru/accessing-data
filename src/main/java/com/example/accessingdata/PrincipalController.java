package com.example.accessingdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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


    // criação do metodo add usuario
    @PostMapping(path = "/add")
    public @ResponseBody String addNovoUsuario(@RequestParam String nome, @RequestParam String email) {
      
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        uRepository.save(u);
        return "ok gravado";
    }


    // criaçao do metodo visualização de todos os usuarios ja cadastrado 
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Usuario> getAllusuario() {
        return uRepository.findAll();
    }

    // metodo criado para atualiza usuario ou substituir
    // PUT para atualiza 
   @PutMapping(path = "/update/{id}")
   public @ResponseBody String updateUsuario(@PathVariable int id ,@RequestParam String nome, @RequestParam String email ){
    
    Usuario u = uRepository.findById(id);
    u.setNome(nome);
    u.setEmail(email);
    uRepository.save(u);
    return "ok ao atualiza";

   }

	// metodo criado para deleta usuario 
    // DELETE   
  @DeleteMapping(path = "/delete/{id}")
  public @ResponseBody String deleteUsuario(@PathVariable int id){
      uRepository.deleteById(id);
    return "ok ao deleta";
  }



}
