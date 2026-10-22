package mx.utez.edu.proyecto1cG.model.persona;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "personas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombres;
    private String primerApellido;
    private String segundoApellido;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(unique = true, nullable = false)
    private String correo;

    @Column(unique = true, nullable = false)
    private String curp;
}