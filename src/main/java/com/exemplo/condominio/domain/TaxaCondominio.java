package com.exemplo.condominio.domain;

import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class TaxaCondominio {

    private final BigDecimal valor;
    private final LocalDate vencimento;

    public TaxaCondominio(BigDecimal valor, LocalDate vencimento) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor da taxa não pode ser negativo.");
        }

        if (vencimento == null) {
            throw new IllegalArgumentException("A data de vencimento é obrigatória.");
        }

        this.valor = valor;
        this.vencimento = vencimento;
    }
}