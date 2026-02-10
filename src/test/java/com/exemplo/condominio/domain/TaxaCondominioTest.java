package com.exemplo.condominio.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TaxaCondominioTest {

    @Test
    @DisplayName("Deve criar uma taxa de condomínio válida")
    void deveCriarTaxaValida() {
        BigDecimal valorEsperado = new BigDecimal("150.00");
        LocalDate vencimentoEsperado = LocalDate.now().plusDays(5);

        TaxaCondominio taxa = new TaxaCondominio(valorEsperado, vencimentoEsperado);

        assertThat(taxa.getValor()).isEqualByComparingTo(valorEsperado);
        assertThat(taxa.getVencimento()).isEqualTo(vencimentoEsperado);
    }

    @Test
    @DisplayName("Não deve criar taxa com valor negativo")
    void deveLancarExcecaoQuandoValorForNegativo() {

        BigDecimal valorNegativo = new BigDecimal("-10.00");
        LocalDate vencimento = LocalDate.now();

        assertThatThrownBy(() -> new TaxaCondominio(valorNegativo, vencimento))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("não pode ser negativo");
    }
}