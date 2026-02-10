package com.exemplo.condominio.application;

import com.exemplo.condominio.domain.TaxaCondominio;
import com.exemplo.condominio.domain.TaxaRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CadastrarTaxaService {

    private final TaxaRepository repository;

    public CadastrarTaxaService(TaxaRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(BigDecimal valor, LocalDate vencimento) {
        TaxaCondominio novaTaxa = new TaxaCondominio(valor, vencimento);
        repository.salvar(novaTaxa);
    }
}