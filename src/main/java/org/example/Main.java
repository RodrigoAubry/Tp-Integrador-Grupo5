package org.example;


import org.example.persistenciaDeDatos.PronosticoPersistenciaDeDatos;
import org.example.persistenciaDeDatos.ResultadoPersistenciaDeDatos;
import org.example.persistenciaDeDatos.h2.ParticipanteH2;
import org.example.persistenciaDeDatos.h2.RondaH2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static <Rondah2> void main(String[] args) throws IOException {

      /*  ************CONEXION CON ARCHIVO ************/

       // ParticipanteArchivo participanteDatos = new ParticipanteArchivo();
       // RondaArchivo rondaDato = new RondaArchivo();

    /*      System.out.println(participanteArchivo.listarTodos().toString());
            System.out.println( estarategiaArchivo.listarTodos().toString());*/

        /*  ************CONEXION CON H2 ************/

        ParticipanteH2 participanteDatos  = new ParticipanteH2();
        participanteDatos.listarTodos();

        RondaH2 rondaDato = new RondaH2();
        rondaDato.listarTodos();


        List<Ronda>  rondas =   listarRondas(rondaDato.listarTodos());
        List<Partido>   listaPartidos = listarPartidos(rondas);
        List<Participante> participantesLista = listarParticipantes(participanteDatos.listarTodos(),listaPartidos);


       // System.out.println(rondas);
       // System.out.println(participanteDatos);
       // System.out.println(listaPartidos);
        System.out.println(participantesLista);
    }

    public static List<Ronda> listarRondas(List<ResultadoPersistenciaDeDatos> ronda) {
        List<Ronda> rondas = new ArrayList<>();
        for (ResultadoPersistenciaDeDatos resultado : ronda) {
            boolean found = false;
            for (Ronda r : rondas) {
                if (r.getId() == resultado.getRonda()) {
                    Equipo equipo1 = new Equipo(resultado.getEquipo1());
                    Equipo equipo2 = new Equipo(resultado.getEquipo2());
                    Partido partido = new Partido(r.getId(),equipo1, equipo2);
                    partido.setGolesEquipo1( resultado.getCantGoles1());
                    partido.setGolesEquipo2( resultado.getCantGoles2());
                    r.agregarPartido(partido);
                    found = true;
                    break;
                }
            }
            if (!found) {
                Ronda r = new Ronda(resultado.getRonda());
                Equipo equipo1 = new Equipo(resultado.getEquipo1());
                Equipo equipo2 = new Equipo(resultado.getEquipo2());
                Partido partido = new Partido(r.getId(),equipo1, equipo2);
                partido.setGolesEquipo1( resultado.getCantGoles1());
                partido.setGolesEquipo2( resultado.getCantGoles2());
                r.agregarPartido(partido);
                rondas.add(r);
            }
        }
        return rondas;
    }

    public static List<Partido> listarPartidos(List<Ronda> rondas) {
        List<Partido> listaPartidos = new ArrayList<>();
        for (Ronda ronda : rondas) {
            for (Partido partidoRonda : ronda.getRondaPartido()) {
                boolean existePartido = false;
                for (Partido p : listaPartidos) {
                    if (p.getIdPartido() == partidoRonda.getIdPartido()) {
                        System.out.println("El partido ya existe en la lista.");
                        existePartido = true;
                        break;
                    }
                }
                if (!existePartido) {
                    listaPartidos.add(partidoRonda);
                }
            }
        }
        return listaPartidos;
    }

    public static List<Participante> listarParticipantes(List<PronosticoPersistenciaDeDatos> listParticipante, List<Partido> partidos){

        List<Participante> participantes = new ArrayList<>();

        for (PronosticoPersistenciaDeDatos participanteArchivo : listParticipante) {
            boolean found = false;
            for (Participante p : participantes) {
                if (p.getNombre().equals(participanteArchivo.getParticipante())) {
                    for(Partido partido : partidos) {
                        if (participanteArchivo.getEquipo1().equals(partido.getEquipo1().getNombre()) &&
                                participanteArchivo.getEquipo2().equals(partido.getEquipo2().getNombre())){
                            Pronostico pronostico = new Pronostico();
                            pronostico.darPronostico(partido , participanteArchivo.getResultado());

                            p.setPronosticoParticipante(pronostico);

                        }
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                Participante participante = new Participante(participanteArchivo.getParticipante());
                for(Partido partido : partidos) {
                    if (participanteArchivo.getEquipo1().equals(partido.getEquipo1().getNombre()) &&
                            participanteArchivo.getEquipo2().equals(partido.getEquipo2().getNombre())){
                        Pronostico pronostico = new Pronostico();
                        pronostico.darPronostico(partido , participanteArchivo.getResultado());
                        participante.setPronosticoParticipante(pronostico);
                    }
                }
                participantes.add(participante);
            }
        }
        try {
            int a=0;
            int aux=participantes.get(0).getPronosticoParticipante().get(0).getPartido().getRonda();
            for (Participante p : participantes) {

                p.puntosYCantitadDeAciertos();

                if(p.getPronosticoParticipante().get(a).getPartido().getRonda()==aux){
                    if(p.getCantAciertos()>=2){
                        p.setBonus(true);
                    }
                }
                a++;
            }
        }catch (Exception e){
            System.out.println("No se encuentra el archivo properties");
        }

        return participantes;
    }
}