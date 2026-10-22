package mx.utez.edu.proyecto1cG.controller.persona;


import jakarta.validation.Valid;

import mx.utez.edu.proyecto1cG.controller.persona.dto.PersonaDTO;
import mx.utez.edu.proyecto1cG.model.persona.Persona;
import mx.utez.edu.proyecto1cG.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(personaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(
            @PathVariable Long id,
            @Valid @RequestBody PersonaDTO dto) {
        return ResponseEntity.ok(personaService.actualizar(id, dto));
    }
}