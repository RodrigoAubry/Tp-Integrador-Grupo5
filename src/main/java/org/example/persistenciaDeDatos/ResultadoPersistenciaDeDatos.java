package org.example.persistenciaDeDatos;

import lombok.Data;
@Data
public class ResultadoPersistenciaDeDatos {
    private int idResultado;
    private int ronda;
    private String equipo1;
    private int cantGoles1;
    private int cantGoles2;
    private String  equipo2;


    public ResultadoPersistenciaDeDatos(int ronda, String equipo1, int cantGoles1, int cantGoles2, String equipo2) {
        this.ronda = ronda;
        this.equipo1 = equipo1;
        this.cantGoles1 = cantGoles1;
        this.cantGoles2 = cantGoles2;
        this.equipo2 = equipo2;
    }

    @Override
    public String toString() {
        return
                '\n' + "ronda: " + ronda + ":  "+
                equipo1 + ' ' +
                cantGoles1 +
                " - " + cantGoles2 +" "+
                 equipo2 + '\n'
                ;
    }
}
