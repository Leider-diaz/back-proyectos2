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
@Table(name = "PEDIDO")
public class Pedido implements Serializable {

    @Serial
    private static final long serialVersionUID = -4456398904478400676L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "ID_ESTADO")
    private Long idEstado;

    //Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESTADO", insertable = false, updatable = false)
    private Estados estados;

}
