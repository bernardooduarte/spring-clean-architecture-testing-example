package com.exemplo.condominio.infrastructure;

import com.exemplo.condominio.domain.TaxaCondominio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "taxas")
@Getter
@Setter
@NoArgsConstructor
public class TaxaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;
    private LocalDate vencimento;
}