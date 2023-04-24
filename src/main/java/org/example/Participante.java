package org.example;

import lombok.Data;

import java.io.FileInputStream;
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


    public void puntosYCantitadDeAciertos(){
        try {
            // Cargar archivo de configuración
            Properties prop = new Properties();
            FileInputStream input = new FileInputStream("valorDePuntos.properties");
            prop.load(input);
            int multiplicadorPuntos = Integer.parseInt(prop.getProperty("multiplicadorPuntos", "1"));


            for (Pronostico p : pronosticoParticipante){
                puntos += multiplicadorPuntos * p.puntos();
                cantAciertos += p.cantAciertos();
            }
        }catch (Exception e){
            System.out.println("Error al leer el archivo");
        }
    }
    public void sumarBonus(){
        try {
            // Cargar archivo de configuración
            Properties prop = new Properties();
            FileInputStream input = new FileInputStream("valorDePuntos.properties");
            prop.load(input);
            int valorBonus = Integer.parseInt(prop.getProperty("valorBonus","0"));

            for (Pronostico p:pronosticoParticipante) {
                if(bonus){
                    this.puntosTotales=valorBonus+puntos;
                }else{
                    this.puntosTotales=puntos;
                }
            }
        }catch (Exception e){
            System.out.println("Error al leer el archivo");
        }
    }

    public void agregarPronosticoParticipante(Pronostico pronosticoParticipante) {
        this.pronosticoParticipante.add(pronosticoParticipante);
    }

    @Override
    public String toString() {
        return "\n"+"Participante " +
                "Nombre: " + nombre + '\n' +
                " puntos: " + puntos + '\n' +
                " Cantidad De Aciertos: " + cantAciertos + '\n' +
                " Cantitad De Apuestas :" + pronosticoParticipante.size() +'\n'+
                " Bonus Por Acerter Una Ronda Completa: " +bonus +'\n'+
                " Puntos Totales: "+puntosTotales+'\n';
    }
}
