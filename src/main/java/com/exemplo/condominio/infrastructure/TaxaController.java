package com.exemplo.condominio.infrastructure;

import com.exemplo.condominio.application.CadastrarTaxaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/taxas")
public class TaxaController {

    private final CadastrarTaxaService service;

    public TaxaController(CadastrarTaxaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody TaxaRequest request) {
        service.cadastrar(request.valor(), request.vencimento());
    }
}

record TaxaRequest(BigDecimal valor, LocalDate vencimento) {}