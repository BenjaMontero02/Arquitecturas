package org.example.Repository;
import org.example.Entitys.Equipo;
import org.example.Entitys.Jugador;

import java.util.List;

public interface IEquipoRepository extends CrudRepository{

    List<Jugador> getAllJugadores(Equipo e);
}
