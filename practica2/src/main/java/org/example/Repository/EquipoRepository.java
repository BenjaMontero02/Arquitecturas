package org.example.Repository;

import org.example.Entitys.Equipo;
import org.example.Entitys.Jugador;

import javax.persistence.EntityManager;
import java.util.List;

public class EquipoRepository implements IEquipoRepository{

    private EntityManager em;

    public EquipoRepository(){
        super();
    }

    public EquipoRepository(EntityManager em){
        this.em = em;
    }
    @Override
    public boolean create(Object obj) {
        try {
            Equipo e = (Equipo)obj;
            em.persist(e);
            return true;
        }catch (Exception exc){
            System.out.println(exc);
        }
        return false;
    }

    @Override
    public void delete(Object obj) {
        try {
            Equipo e = (Equipo)obj;
            this.em.remove(e);
        }catch (Exception exc){
            System.out.println(exc);
        }
    }

    @Override
    public Object get(Long id) {
        return this.em.find(Equipo.class, id);
    }

    @Override
    public void update(Object obj) {
        Equipo e = (Equipo)obj;
        this.em.merge(e);
    }

    @Override
    public List<Jugador> getAllJugadores(Equipo e){
        return e.getJugadores();
    }
}
