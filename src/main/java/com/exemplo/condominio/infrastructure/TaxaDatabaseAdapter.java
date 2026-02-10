package com.exemplo.condominio.infrastructure;

import com.exemplo.condominio.domain.TaxaCondominio;
import com.exemplo.condominio.domain.TaxaRepository;
import org.springframework.stereotype.Component;

@Component
public class TaxaDatabaseAdapter implements TaxaRepository {
    private final TaxaJpaRepository jpaRepository;
    private final TaxaMapper mapper;

    public TaxaDatabaseAdapter(TaxaJpaRepository jpaRepository, TaxaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void salvar(TaxaCondominio taxa) {
        jpaRepository.save(mapper.toEntity(taxa));
    }
}