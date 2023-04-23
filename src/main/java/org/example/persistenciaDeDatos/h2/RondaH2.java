package org.example.persistenciaDeDatos.h2;

import lombok.Data;
import org.example.persistenciaDeDatos.ResultadoPersistenciaDeDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Data
public class RondaH2 {

    static final String DB_URL = "jdbc:h2:mem:;INIT=runscript from 'initResultado.sql'";
    Connection conn = null;
    Statement stmt = null;
    public RondaH2() {
    }
    public List<ResultadoPersistenciaDeDatos> listarTodos() {
        List<ResultadoPersistenciaDeDatos> resultados = null;
        try {
            resultados = new ArrayList<>();
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Resultados");
            // Encabezado de la tabla
          /*  System.out.println("\nMostrando la tabla de Resultados: \n");

            System.out.printf("%-20s", "idResultado");
            System.out.printf("%-20s", "Ronda");
            System.out.printf("%-20s", "Equipo1");
            System.out.printf("%-20s", "cantGoles1");
            System.out.printf("%-20s", "cantGoles2");
            System.out.printf("%-20s %n", "Equipo2");*/

            while (rs.next()) {
                // Definimos las columnas
                int idResultado = rs.getInt("idResultado");
                int ronda = rs.getInt("ronda");
                String eq1 = rs.getString("equipo1");
                int cantGoles1 = rs.getInt("cantGoles1");
                int cantGoles2 = rs.getInt("cantGoles2");
                String eq2 = rs.getString("equipo2");

                // Mostrando por consola

             /*   System.out.printf("%-20s", idResultado);
                System.out.printf("%-20s", ronda);
                System.out.printf("%-20s", eq1);
                System.out.printf("%-20s", cantGoles1);
                System.out.printf("%-20s", cantGoles2);
                System.out.printf("%-20s %n", eq2);*/

                ResultadoPersistenciaDeDatos resultado = new ResultadoPersistenciaDeDatos(ronda, eq1,cantGoles1,cantGoles2,eq2);
                resultado.setIdResultado(idResultado);
                resultados.add(resultado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }
}
