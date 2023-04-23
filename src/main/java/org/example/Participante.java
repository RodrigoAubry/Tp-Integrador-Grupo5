package org.example;

import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Data
public class Participante {
    private  String nombre;
    private int puntos,puntosTotales ;
    private List<Pronostico> pronosticoParticipante;
    private int cantAciertos;
    private boolean bonus;

    public Participante(String nombre) {
        this.nombre = nombre;
        this.puntos =0;
        pronosticoParticipante = new ArrayList<>();
        this.cantAciertos = 0;
    }


    public void puntosYCantitadDeAciertos() throws IOException {
        try {
            // Cargar archivo de configuración
            Properties prop = new Properties();
            FileInputStream input = new FileInputStream("valorDePuntos.properties");
            prop.load(input);
            int multiplicador = Integer.parseInt(prop.getProperty("multiplicador", "1"));

            for (Pronostico p : pronosticoParticipante){
                puntos += multiplicador * p.puntos();
                cantAciertos += p.cantAciertos();
            }
        }catch (Exception e){}
    }

    public void setPronosticoParticipante(Pronostico pronosticoParticipante) {
        this.pronosticoParticipante.add(pronosticoParticipante);
    }

    public boolean acertoTodo (){
        boolean acierto = false;
        if(pronosticoParticipante.size() == cantAciertos){
            acierto = true;
        }
        return acierto;
    }

    @Override
    public String toString() {
        return "\n"+"Participante " +
                "Nombre: " + nombre + '\n' +
                " puntos: " + puntos + '\n' +
                " Cantidad De Aciertos: " + cantAciertos + '\n' +
                " Cantitad De Apuestas :" + pronosticoParticipante.size() +'\n'
               /* " Bonus Por Acerter Una Ronda Completa: " +bonus +'\n'+
                "Puntos Totales: "+puntosTotales+'\n'*/

                +"\n";
    }
}
