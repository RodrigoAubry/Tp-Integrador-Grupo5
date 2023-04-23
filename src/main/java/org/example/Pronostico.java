package org.example;

import lombok.Data;

@Data
public class Pronostico {
    private Partido partido;
    private Resultado pronostico;


    public void darPronostico(Partido partido, Resultado pronostico) {
        this.partido = partido;
        this.pronostico = pronostico;
    }

    public int puntos (){
        int puntos = 0;
        if(partido.resultadoPartido() == pronostico){
            puntos = 1;
        }
        return puntos;
    }
    public int cantAciertos (){
        int aciertos = 0;
        if(partido.resultadoPartido() == pronostico){
            aciertos = 1;
        }
        return aciertos;
    }

    @Override
    public String toString() {
        return "\n" +
                 partido +
                "  pronostico:" + pronostico + "\n";
    }
}
