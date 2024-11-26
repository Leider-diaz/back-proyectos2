package com.soft2.sistemacompras.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Leider
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = -3625217680126574727L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOMBRES")
    private String nombre;
    @Column(name = "APELLIDOS")
    private String apellido;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "USERNAME")
    private String username;

    @JsonIgnore
    @Formula("NOMBRES || ' ' || APELLIDOS")
    private String nombreApellidos;

}
