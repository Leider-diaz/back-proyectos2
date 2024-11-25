package com.soft2.sistemacompras.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author Leider
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DETALLE_PEDIDO")
public class DetallePedido implements Serializable {

    @Serial
    private static final long serialVersionUID = -5373589849346451203L;

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
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCTO", insertable = false, updatable = false)
    private Producto producto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PEDIDO", insertable = false, updatable = false)
    private Pedido pedido;



}
