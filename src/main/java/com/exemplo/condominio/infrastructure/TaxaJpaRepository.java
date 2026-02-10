package com.exemplo.condominio.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxaJpaRepository extends JpaRepository<TaxaEntity, Long> {
}