package mx.utez.edu.proyecto1cG.service;

import mx.utez.edu.proyecto1cG.controller.persona.dto.PersonaDTO;
import mx.utez.edu.proyecto1cG.model.persona.Persona;
import mx.utez.edu.proyecto1cG.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Transactional(readOnly = true)
    public Persona obtenerPorId(Long id) {
        return personaRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada con ID: " + id));
    }

    @Transactional
    public Persona actualizar(Long id, PersonaDTO dto) {
        Persona persona = obtenerPorId(id);

        if (personaRepository.existsByCorreoAndIdNot(dto.getCorreo(), id)) {
            throw new RuntimeException("El correo ya esta registrado por otra persona");
        }
        if (personaRepository.existsByCurpAndIdNot(dto.getCurp(), id)) {
            throw new RuntimeException("La CURP ya esta registrada por otra persona");
        }

        persona.setNombres(dto.getNombres());
        persona.setPrimerApellido(dto.getPrimerApellido());
        persona.setSegundoApellido(dto.getSegundoApellido());
        persona.setFechaNacimiento(dto.getFechaNacimiento());
        persona.setCorreo(dto.getCorreo());
        persona.setCurp(dto.getCurp());

        return personaRepository.save(persona);
    }
}