package com.arquitecturas.repository;

import com.arquitecturas.domain.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    Grupo findByNombre(String name);
}
