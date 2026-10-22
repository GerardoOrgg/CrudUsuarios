package mx.utez.edu.proyecto1cG.controller.usuario.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUpdateDTO {

    @NotBlank(message = "El username no puede estar vacio")
    private String username;

    private String descripccion;
}