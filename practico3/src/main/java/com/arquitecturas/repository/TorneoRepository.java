package com.arquitecturas.repository;

import com.arquitecturas.domain.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneoRepository extends JpaRepository<Torneo, Long> {

    Torneo findByNombre(String s);

}
