package org.example.persistenciaDeDatos.archivo;
import org.example.persistenciaDeDatos.ResultadoPersistenciaDeDatos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RondaArchivo {


        /*    Equipo equipo1 = new Equipo();
            equipo1.setNombre(elementosRes[1]);
            Equipo equipo2 = new Equipo();
            equipo2.setNombre(elementosRes[4]);

            Partido partido = new Partido();
            partido.setRonda(Integer.parseInt(elementosRes[0]));
            partido.setEquipo1(equipo1);
            partido.setEquipo2(equipo2);
            partido.setGolesEquipo1(Integer.parseInt(elementosRes[2]));
            partido.setGolesEquipo2(Integer.parseInt(elementosRes[3]));

            partidos.add(partido); */


   // @Override
    public List<ResultadoPersistenciaDeDatos> listarTodos() throws IOException {
        List<String> allLines = Files.readAllLines(Paths.get("resultados.csv"));
        List<ResultadoPersistenciaDeDatos> resultados = new ArrayList<>();
        for (int j = 1; j < allLines.size(); j++) {
            String archivoResultado = allLines.get(j);
            String[] campos = archivoResultado.split(",");
            ResultadoPersistenciaDeDatos resultado = new ResultadoPersistenciaDeDatos(Integer.parseInt(campos[0]) ,campos[1] , Integer.parseInt(campos[2]) , Integer.parseInt(campos[3]) , campos[4]);
            resultados.add(resultado);
        }
        return resultados;
    }
}


