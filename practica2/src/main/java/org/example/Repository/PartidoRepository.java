package org.example.Repository;

import org.example.Entitys.Equipo;
import org.example.Entitys.Jugador;
import org.example.Entitys.Partido;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class PartidoRepository implements CrudRepository{
    private EntityManager em;

    public PartidoRepository(){
        super();
    }

    public PartidoRepository(EntityManager em){
        super();
        this.em = em;
    }
    @Override
    public boolean create(Object obj) {
        try {
            Partido p = (Partido)obj;
            em.persist(p);
            return true;
        }catch (Exception exc){
            System.out.println(exc);
        }
        return false;
    }

    @Override
    public void delete(Object obj) {
        try {
            Partido p = (Partido)obj;
            this.em.remove(p);
        }catch (Exception exc){
            System.out.println(exc);
        }
    }

    @Override
    public Object get(Long id) {
        return this.em.find(Partido.class, id);
    }

    @Override
    public void update(Object obj) {
        Partido p = (Partido)obj;
        this.em.merge(p);
    }

}
