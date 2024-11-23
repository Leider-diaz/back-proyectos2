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
@Table(name = "PRODUCTOS_CARRITO")
public class ProductosCarrito implements Serializable {

    @Serial
    private static final long serialVersionUID = -1948577330406875857L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "ID_PRODUCTO")
    private Long idProducto;

    @Column(name = "CANTIDAD")
    private Long cantidad;

    //Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCTO", insertable = false, updatable = false)
    private Producto producto;


}
