package org.example.persistenciaDeDatos.archivo;

import lombok.Data;
import org.example.Resultado;
import org.example.persistenciaDeDatos.PronosticoPersistenciaDeDatos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@Data
public class ParticipanteArchivo {

    public List<PronosticoPersistenciaDeDatos> listarTodos() throws IOException {
        List<String> allLines = Files.readAllLines(Paths.get("pronostico.csv"));
        List<PronosticoPersistenciaDeDatos> pronosticos = new ArrayList<>();
        for (int j = 1; j < allLines.size(); j++) {
            String archivoPronostico= allLines.get(j);
            String[] campos = archivoPronostico.split(",");
            Resultado resultado;
            if(!campos[2].equals("")){
               resultado = Resultado.GANADOR_EQUIPO1;
            } else if (!campos[3].equals("")) {
                resultado = Resultado.EMPATE;
            }else { resultado = Resultado.GANADOR_EQUIPO2;}
            PronosticoPersistenciaDeDatos pronostico = new PronosticoPersistenciaDeDatos(campos[0], campos[1],campos[5], resultado );
            pronosticos.add(pronostico);
        }
        return pronosticos;
    }
}
