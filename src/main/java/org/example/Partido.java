package org.example;

import lombok.Data;

@Data
public class Partido {

    private Equipo equipo1 , equipo2;
    private int golesEquipo1 , golesEquipo2, ronda;
    private Resultado resultado;
    private int idPartido ;
    private static int contador = 0;

    public Partido(int ronda, Equipo equipo1, Equipo equipo2) {
        this.ronda=ronda;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        idPartido = ++contador;
    }

    public Resultado resultadoPartido(){

        if(golesEquipo1 == golesEquipo2){
            resultado = Resultado.EMPATE;
        }
        else if(golesEquipo1 > golesEquipo2){
            resultado = Resultado.GANADOR_EQUIPO1;
        }
        else resultado = Resultado.GANADOR_EQUIPO2;

        return resultado;
    }

    @Override
    public String toString() {
        return  "Partido "+ idPartido +
                ": equipo1: " + equipo1 +
                " " + golesEquipo1 +
                " - equipo2: " + equipo2 +
                "  " + golesEquipo2 +
                " resultado: " + resultado +
                '\n';
    }
}
