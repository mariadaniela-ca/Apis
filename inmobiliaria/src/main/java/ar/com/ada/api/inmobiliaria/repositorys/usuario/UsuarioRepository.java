package ar.com.ada.api.inmobiliaria.repositorys.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.inmobiliaria.entities.usuario.Usuario;

/**
 * UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario , Integer>{
    
    Usuario findByEmail(String email);

    Usuario findByUsername(String username);
    
}