package org.example.Repository;

import org.example.Entitys.Jugador;

import javax.persistence.EntityManager;

public class JugadorRepository implements CrudRepository{

    private EntityManager em;

    public JugadorRepository(){
        super();
    }

    public JugadorRepository(EntityManager em){
        super();
        this.em = em;
    }
    @Override
    public boolean create(Object obj) {
        try {
            Jugador j = (Jugador)obj;
            em.persist(j);
            return true;
        }catch (Exception exc){
            System.out.println(exc);
        }
        return false;
    }

    @Override
    public void delete(Object obj) {
        try {
            Jugador j = (Jugador)obj;
            this.em.remove(j);
        }catch (Exception exc){
            System.out.println(exc);
        }
    }

    @Override
    public Object get(Long id) {
        return this.em.find(Jugador.class, id);
    }

    @Override
    public void update(Object obj) {
        Jugador j = (Jugador)obj;
        this.em.merge(j);
    }
}
