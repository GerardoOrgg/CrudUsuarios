package mx.utez.edu.proyecto1cG.controller.usuario.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioCreateDTO {

    @NotBlank(message = "El username es obligatorio")
    private String username;

    private String descripcion;
}