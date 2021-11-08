package org.serratec.backend.h2banco.repository;

import org.serratec.backend.h2banco.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email); //serve para buscar um usuario pelo email.
}
