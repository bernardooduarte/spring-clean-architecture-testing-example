package com.exemplo.condominio.application;

import com.exemplo.condominio.domain.TaxaCondominio;
import com.exemplo.condominio.domain.TaxaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class) // Habilita o uso das anotações @Mock
class CadastrarTaxaServiceTest {

    @Mock
    private TaxaRepository repository; // O "Proxy" que você descreveu 🎭

    @InjectMocks
    private CadastrarTaxaService service; // A classe que testaremos

    @Test
    @DisplayName("Deve salvar a taxa quando os dados forem válidos")
    void deveSalvarTaxa() {
        BigDecimal valor = new BigDecimal("200.00");
        LocalDate vencimento = LocalDate.now();

        service.cadastrar(valor, vencimento);

        verify(repository, times(1)).salvar(any(TaxaCondominio.class));
    }
}