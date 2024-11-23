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
@Table(name = "DETALLE_PEDIDO")
public class DetallePedido implements Serializable {

    @Serial
    private static final long serialVersionUID = -4002163868271124000L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_PRODUCTO")
    private Long idProducto;

    @Column(name = "ID_PEDIDO")
    private Long idPedido;

    @Column(name = "CANTIDAD")
    private Long cantidad;


    //Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCTO", insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PEDIDO", insertable = false, updatable = false)
    private Pedido pedido;



}
