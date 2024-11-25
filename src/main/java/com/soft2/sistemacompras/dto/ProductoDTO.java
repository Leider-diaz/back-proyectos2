package com.soft2.sistemacompras.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoDTO implements Serializable {
    private static final long serialVersionUID = 840951374022826609L;
    private String product_name;
    private Long quantity;
    private BigDecimal price;
}
