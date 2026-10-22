package mx.utez.edu.proyecto1cG.repository;

import mx.utez.edu.proyecto1cG.model.persona.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    boolean existsByCorreoAndIdNot(String correo, Long id);
    boolean existsByCurpAndIdNot(String curp, Long id);
}