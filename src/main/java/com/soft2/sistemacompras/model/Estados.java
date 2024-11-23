package com.soft2.sistemacompras.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author Leider
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "ESTADOS")
public class Estados implements Serializable {

    @Serial
    private static final long serialVersionUID = -7024115586941469656L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "SIGLA")
    private String sigla;

}
