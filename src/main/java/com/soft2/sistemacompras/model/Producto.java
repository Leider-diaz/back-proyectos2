package com.soft2.sistemacompras.model;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Leider
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCTO", schema = "SISTEMACOMPRA")
public class Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = -1400606624174325804L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO")
    private BigDecimal precio;

    @Column(name = "CANTIDAD")
    private Long cantidad;

    @Column(name = "ID_TIPO_PRODUCTO")
    private Long idTipoProducto;

    //Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_PRODUCTO", insertable = false, updatable = false)
    private TipoProducto tipoProducto;

}
