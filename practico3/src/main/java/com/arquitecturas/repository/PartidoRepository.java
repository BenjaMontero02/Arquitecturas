package com.arquitecturas.repository;

import com.arquitecturas.domain.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
}
