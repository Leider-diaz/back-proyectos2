package com.soft2.sistemacompras.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDTO implements Serializable {
    private static final long serialVersionUID = 877547711092260768L;
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String status;
    private String store;
    private String costumer_name;
    private BigDecimal total_price;
    private List<ProductoDTO> products;
}
