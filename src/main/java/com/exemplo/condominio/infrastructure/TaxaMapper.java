package com.exemplo.condominio.infrastructure;

import com.exemplo.condominio.domain.TaxaCondominio;
import org.springframework.stereotype.Component;

@Component
public class TaxaMapper {

    public TaxaEntity toEntity(TaxaCondominio dominio) {
        TaxaEntity entity = new TaxaEntity();
        entity.setValor(dominio.getValor());
        entity.setVencimento(dominio.getVencimento());
        return entity;
    }

    public TaxaCondominio toDomain(TaxaEntity entity) {
        return new TaxaCondominio(entity.getValor(), entity.getVencimento());
    }
}