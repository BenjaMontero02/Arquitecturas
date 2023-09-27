package com.arquitecturas.repository;

import com.arquitecturas.domain.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    Optional<Equipo> findByNombreAndTecnico(String nombre, String tecnico);

    Equipo findByNombre(String nombre);
}
