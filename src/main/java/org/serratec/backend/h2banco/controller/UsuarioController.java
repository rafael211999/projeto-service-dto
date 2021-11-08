package org.serratec.backend.h2banco.controller;

import java.util.List;

import org.serratec.backend.h2banco.domain.Usuario;
import org.serratec.backend.h2banco.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
 @Autowired
 private UsuarioService usuarioService;
 
 @GetMapping
 public ResponseEntity<List<Usuario>> pesquisarTodos() {
	 return ResponseEntity.ok(usuarioService.listarTodos());
 }
 
 
 
 @PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario user, UriComponentsBuilder b) {
		Usuario usuario = usuarioService.inserir(user);
		UriComponents uriComponents = b.path("/usuarios/{id}").buildAndExpand(usuario.getId());
		return ResponseEntity.created(uriComponents.toUri()).body(usuario);
	}
 
}
