package mx.utez.edu.proyecto1cG.repository;

import mx.utez.edu.proyecto1cG.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByUsernameAndIdNot(String username, Long id);
    boolean existsByUsername(String username);
}