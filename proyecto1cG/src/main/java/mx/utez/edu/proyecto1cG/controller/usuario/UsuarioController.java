package mx.utez.edu.proyecto1cG.controller.usuario;

import jakarta.validation.Valid;
import mx.utez.edu.proyecto1cG.controller.usuario.dto.UsuarioCreateDTO;
import mx.utez.edu.proyecto1cG.controller.usuario.dto.UsuarioUpdateDTO;
import mx.utez.edu.proyecto1cG.model.usuario.Usuario;
import mx.utez.edu.proyecto1cG.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@Valid @RequestBody UsuarioCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crear(dto));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Usuario> cambiarEstado(@PathVariable Long id, @RequestParam boolean enable) {
        return ResponseEntity.ok(usuarioService.cambiarEstado(id, enable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioUpdateDTO dto) {
        return ResponseEntity.ok(usuarioService.actualizarUsernameYDescripcion(id, dto));
    }
}