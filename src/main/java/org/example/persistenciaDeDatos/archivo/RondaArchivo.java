package org.example.persistenciaDeDatos.archivo;
import lombok.Data;
import org.example.persistenciaDeDatos.ResultadoPersistenciaDeDatos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@Data
public class RondaArchivo {

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


