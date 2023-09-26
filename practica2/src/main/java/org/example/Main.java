package org.example;

import org.example.DTOs.DTOGolTable;
import org.example.DTOs.DTOTable;
import org.example.Entitys.*;
import org.example.Repository.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TorneoRepository tr = new TorneoRepository(em);
        EquipoRepository er = new EquipoRepository(em);
        JugadorRepository jr = new JugadorRepository(em);

        Equipo river = new Equipo("river", "marcelo gallardo");
        Equipo boca = new Equipo("boca", "almibot");
        Equipo racing = new Equipo("racing", "gaga");
        Equipo independiente = new Equipo("independiente", "mono");
        Equipo sanlorenzo = new Equipo("sanlorenzo", "insua");
        Equipo talleres = new Equipo("talleres", "guardiola");
        Equipo estudiantes = new Equipo("estudiantes", "carlos");
        Equipo lanus = new Equipo("lanus", "pepo");

        Jugador uno = new Jugador("arquero", "juan",river, true);
        Jugador dos = new Jugador("defensa", "rodrigo",river, true);
        Jugador tres = new Jugador("delantero", "carlos", river, true);
        Jugador cuatro = new Jugador("arquero", "juan",river, true);
        Jugador cinco = new Jugador("defensa", "rodrigo",river, true);
        Jugador seis = new Jugador("delantero", "carlos", river, true);
        Jugador siete = new Jugador("arquero", "juan",river, true);

        river.addJugador(uno);
        river.addJugador(dos);
        river.addJugador(tres);
        river.addJugador(cuatro);
        river.addJugador(cinco);
        river.addJugador(seis);
        river.addJugador(siete);

        Jugador ocho = new Jugador("arquero", "matias", boca,true);
        Jugador nueve = new Jugador("defensa", "brian", boca,true);
        Jugador diez = new Jugador("delantero", "lucas", boca,true);
        Jugador once = new Jugador("arquero", "matias", boca,true);
        Jugador doce = new Jugador("defensa", "brian", boca,true);
        Jugador trece = new Jugador("delantero", "lucas", boca,true);
        Jugador catorce = new Jugador("arquero", "matias", boca,true);

        boca.addJugadores(ocho);
        boca.addJugadores(nueve);
        boca.addJugadores(diez);
        boca.addJugadores(once);
        boca.addJugadores(doce);
        boca.addJugadores(trece);
        boca.addJugadores(catorce);


        Jugador quince = new Jugador("arquero", "fidel", racing,true);
        Jugador dieciseis = new Jugador("defensa", "lautaro", racing,true);
        Jugador diciocho = new Jugador("delantero", "gabriel", racing,true);
        Jugador veinte = new Jugador("arquero", "fidel", racing,true);
        Jugador veintiuno = new Jugador("defensa", "lautaro", racing,true);
        Jugador vdos = new Jugador("delantero", "gabriel", racing,true);
        Jugador vtres = new Jugador("arquero", "fidel", racing,true);

        racing.addJugadores(quince);
        racing.addJugadores(dieciseis);
        racing.addJugadores(diciocho);
        racing.addJugadores(veinte);
        racing.addJugadores(veintiuno);
        racing.addJugadores(vdos);
        racing.addJugadores(vtres);

        Jugador vcuatro = new Jugador("arquero", "mauro", independiente, true);
        Jugador vcinco = new Jugador("defensa", "mario", independiente, true);
        Jugador vseis = new Jugador("delantero", "cristian", independiente,true);
        Jugador vsiete = new Jugador("arquero", "mauro", independiente, true);
        Jugador vocho = new Jugador("defensa", "mario", independiente, true);
        Jugador vnueve = new Jugador("delantero", "cristian", independiente,true);
        Jugador vdiez = new Jugador("arquero", "mauro", independiente, true);

        independiente.addJugadores(vcuatro);
        independiente.addJugadores(vcinco);
        independiente.addJugadores(vseis);
        independiente.addJugadores(vsiete);
        independiente.addJugadores(vocho);
        independiente.addJugadores(vnueve);
        independiente.addJugadores(vdiez);

        Jugador tuno = new Jugador("arquero", "mauro", talleres, true);
        Jugador tdos = new Jugador("defensa", "mario", talleres, true);
        Jugador ttres = new Jugador("delantero", "cristian", talleres,true);
        Jugador tcuatro = new Jugador("arquero", "mauro", talleres, true);
        Jugador tcinco = new Jugador("defensa", "mario", talleres, true);
        Jugador tseis = new Jugador("delantero", "cristian", talleres,true);
        Jugador tsiete = new Jugador("arquero", "mauro", talleres, true);

        talleres.addJugadores(tuno);
        talleres.addJugadores(tdos);
        talleres.addJugadores(ttres);
        talleres.addJugadores(tcuatro);
        talleres.addJugadores(tcinco);
        talleres.addJugadores(tseis);
        talleres.addJugadores(tsiete);


        Jugador tocho = new Jugador("defensa", "brian", sanlorenzo,true);
        Jugador tnueve = new Jugador("delantero", "lucas", sanlorenzo,true);
        Jugador tdiez = new Jugador("arquero", "matias", sanlorenzo,true);
        Jugador cuno = new Jugador("defensa", "brian", sanlorenzo,true);
        Jugador cdos = new Jugador("delantero", "lucas", sanlorenzo,true);
        Jugador ctres = new Jugador("arquero", "matias", sanlorenzo,true);
        Jugador ccuatro = new Jugador("arquero", "matias", sanlorenzo,true);

        sanlorenzo.addJugadores(tocho);
        sanlorenzo.addJugadores(tnueve);
        sanlorenzo.addJugadores(tdiez);
        sanlorenzo.addJugadores(cuno);
        sanlorenzo.addJugadores(cdos);
        sanlorenzo.addJugadores(ctres);
        sanlorenzo.addJugadores(ccuatro);

        Jugador ccinco = new Jugador("defensa", "brian", estudiantes,true);
        Jugador cseis = new Jugador("delantero", "lucas", estudiantes,true);
        Jugador csiete = new Jugador("arquero", "matias", estudiantes,true);
        Jugador cocho = new Jugador("defensa", "brian", estudiantes,true);
        Jugador cnueve = new Jugador("delantero", "lucas", estudiantes,true);
        Jugador cdiez = new Jugador("arquero", "matias", estudiantes,true);
        Jugador suno = new Jugador("arquero", "matias", estudiantes,true);

        estudiantes.addJugadores(ccinco);
        estudiantes.addJugadores(cseis);
        estudiantes.addJugadores(csiete);
        estudiantes.addJugadores(cocho);
        estudiantes.addJugadores(cnueve);
        estudiantes.addJugadores(cdiez);
        estudiantes.addJugadores(suno);

        Jugador sdos = new Jugador("defensa", "rodrigo",lanus, true);
        Jugador stres = new Jugador("delantero", "carlos", lanus, true);
        Jugador scuatro = new Jugador("arquero", "juan",lanus, true);
        Jugador scinco = new Jugador("defensa", "rodrigo",lanus, true);
        Jugador sseis = new Jugador("delantero", "carlos", lanus, true);
        Jugador ssiete = new Jugador("arquero", "juan",lanus, true);
        Jugador socho = new Jugador("arquero", "juan",lanus, true);

        lanus.addJugadores(sdos);
        lanus.addJugadores(stres);
        lanus.addJugadores(scuatro);
        lanus.addJugadores(scinco);
        lanus.addJugadores(sseis);
        lanus.addJugadores(ssiete);
        lanus.addJugadores(socho);

        Torneo t = new Torneo("libertadores");

        Grupo g1 = new Grupo("g1");
        Grupo g2 = new Grupo("g2");

        t.addGrupo(g1);
        t.addGrupo(g2);

        g1.addEquipo(river);
        g1.addEquipo(boca);
        g1.addEquipo(racing);
        g1.addEquipo(independiente);

        g2.addEquipo(lanus);
        g2.addEquipo(talleres);
        g2.addEquipo(estudiantes);
        g2.addEquipo(sanlorenzo);

        Partido p = new Partido(Timestamp.valueOf(LocalDate.of(2023, 2, 4).atStartOfDay()), "3-1", river, boca);
        Punto pu = new Punto(river, 3);
        p.addPunto(pu);
        Gol gol1 = new Gol(uno, 3);
        Gol gol2 = new Gol(ocho, 1);
        p.addGol(gol1);
        p.addGol(gol2);

        Partido p1 = new Partido(Timestamp.valueOf(LocalDate.of(2023, 2, 4).atStartOfDay()), "3-1", river, independiente);
        Punto pu1 = new Punto(river, 3);
        p1.addPunto(pu1);
        Gol gol3 = new Gol(uno, 3);
        Gol gol4 = new Gol(vcuatro, 1);
        p1.addGol(gol4);
        p1.addGol(gol3);

        Partido p2 = new Partido(Timestamp.valueOf(LocalDate.of(2023, 2, 4).atStartOfDay()), "3-1", independiente, racing);
        Punto pu2 = new Punto(independiente, 3);
        p2.addPunto(pu2);
        Gol gol5 = new Gol(vcuatro, 3);
        Gol gol6 = new Gol(quince, 1);
        p2.addGol(gol5);
        p2.addGol(gol6);

        g1.addPartido(p);
        g1.addPartido(p1);
        g1.addPartido(p2);

        Partido p3 = new Partido(Timestamp.valueOf(LocalDate.of(2023, 2, 4).atStartOfDay()), "3-1", sanlorenzo, talleres);
        Punto pu3 = new Punto(sanlorenzo, 3);
        p3.addPunto(pu3);
        Gol gol7 = new Gol(tocho, 3);
        Gol gol8 = new Gol(tuno, 1);
        p3.addGol(gol7);
        p3.addGol(gol8);

        Partido p4 = new Partido(Timestamp.valueOf(LocalDate.of(2023, 2, 4).atStartOfDay()), "3-1", lanus, estudiantes);
        Punto pu4 = new Punto(lanus, 3);
        p4.addPunto(pu4);
        Gol gol9 = new Gol(sdos, 3);
        Gol gol10 = new Gol(ccinco, 1);
        p4.addGol(gol9);
        p4.addGol(gol10);

        Partido p5 = new Partido(Timestamp.valueOf(LocalDate.of(2023, 2, 4).atStartOfDay()), "3-1", lanus, talleres);
        Punto pu5 = new Punto(lanus, 3);
        p5.addPunto(pu5);
        Gol gol11 = new Gol(sdos, 3);
        Gol gol12 = new Gol(tuno, 1);
        p5.addGol(gol11);
        p5.addGol(gol12);

        g2.addPartido(p3);
        g2.addPartido(p4);
        g2.addPartido(p5);


        tr.create(t);
        //tr.update(t);
        List<DTOTable>tabla =  tr.generatedTableOfPositions(1L, Timestamp.valueOf(LocalDate.now().atStartOfDay()), 2L);

        System.out.println(tabla);

        List<DTOGolTable> golTabla = tr.generatedTableOfGol(1L, Timestamp.valueOf(LocalDate.now().atStartOfDay()));

        System.out.println(golTabla);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}