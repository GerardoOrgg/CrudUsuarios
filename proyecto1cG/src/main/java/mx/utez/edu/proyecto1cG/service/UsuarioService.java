package mx.utez.edu.proyecto1cG.service;

import mx.utez.edu.proyecto1cG.controller.usuario.dto.UsuarioCreateDTO;
import mx.utez.edu.proyecto1cG.controller.usuario.dto.UsuarioUpdateDTO;
import mx.utez.edu.proyecto1cG.model.usuario.Usuario;
import mx.utez.edu.proyecto1cG.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    @Transactional
    public Usuario cambiarEstado(Long id, boolean estado) {
        Usuario usuario = obtenerPorId(id);
        usuario.setEnable(estado);
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario actualizarUsernameYDescripcion(Long id, UsuarioUpdateDTO dto) {
        Usuario usuario = obtenerPorId(id);

        if (usuarioRepository.existsByUsernameAndIdNot(dto.getUsername(), id)) {
            throw new RuntimeException("El nombre de usuario '" + dto.getUsername() + "' ya esta en uso");
        }

        usuario.setUsername(dto.getUsername());
        usuario.setDescripcion(dto.getDescripccion());

        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario crear(UsuarioCreateDTO dto) {
        if (usuarioRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("El username ya esta registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setDescripcion(dto.getDescripcion());
        usuario.setEnable(true);

        return usuarioRepository.save(usuario);
    }

}