package org.example.persistenciaDeDatos;

import lombok.Data;
import org.example.Resultado;
@Data
public class PronosticoPersistenciaDeDatos {
    private int idPronostico;
    private String participante;
    private String equipo1;
    private String equipo2;
    private Resultado resultado;

    public PronosticoPersistenciaDeDatos(String participante, String equipo1, String equipo2, Resultado resultado) {
        this.participante = participante;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
    }


    @Override
    public String toString() {
        return  "\n" +"Pronostico: \n " +
                "participante: " + participante +
                " equipo1: " + equipo1 + ' ' +
                " equipo2: " + equipo2 + ' ' +
                " resultado: " + resultado + '\n'
                ;
    }


    public void setIdResultado(int idResultado) {
        this.idPronostico = idResultado;
    }
}
