package org.serratec.backend.h2banco.service;

import java.util.List;

import org.serratec.backend.h2banco.domain.Usuario;
import org.serratec.backend.h2banco.exception.EmailException;
import org.serratec.backend.h2banco.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder passWordEncoder;

	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	public Usuario inserir(Usuario user) throws EmailException {
		Usuario usuario = usuarioRepository.findByEmail(user.getEmail());
		if (usuario != null) {
			throw new EmailException("Email já existente");
		}
		user.setSenha(passWordEncoder.encode(user.getSenha()));
		return usuarioRepository.save(user);

	}
}
