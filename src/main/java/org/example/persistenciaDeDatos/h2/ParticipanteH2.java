package org.example.persistenciaDeDatos.h2;

import org.example.Resultado;
import org.example.persistenciaDeDatos.PronosticoPersistenciaDeDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteH2 {

    static final String DB_URL = "jdbc:h2:mem:;INIT=runscript from 'init.sql'";

    Connection conn = null;
    Statement stmt = null;

    public ParticipanteH2() {
    }

    public List<PronosticoPersistenciaDeDatos> listarTodos() {
        List<PronosticoPersistenciaDeDatos> pronosticos = null;
        try {
            pronosticos = new ArrayList<>();

            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Pronosticos");
            // Encabezado de la tabla
           /* System.out.println("\nMostrando la tabla de Pronosticos: \n");

            System.out.printf("%-20s", "idPronostico");
            System.out.printf("%-20s", "Participante");
            System.out.printf("%-20s", "Equipo1");
            System.out.printf("%-20s", "Resultado");
            System.out.printf("%-20s %n", "Equipo2");*/

            while (rs.next()) {
                // Definimos cada columna
                int idPronostico = rs.getInt("idPronostico");
                String part = rs.getString("participante");
                String eq1 = rs.getString("equipo1");
                String resultado = rs.getString("resultado");
                String eq2 = rs.getString("equipo2");
                Resultado resul;
                if (resultado.equals("Gana 1")) {
                    resul = Resultado.GANADOR_EQUIPO1;
                } else if (resultado.equals("Gana 2")) {
                    resul = Resultado.GANADOR_EQUIPO2;
                } else {
                    resul = Resultado.EMPATE;
                }
                PronosticoPersistenciaDeDatos pronostico = new PronosticoPersistenciaDeDatos(part, eq1, eq2, resul);
                pronostico.setIdResultado(idPronostico);
                pronosticos.add(pronostico);
                // Mostrando por consola

             /*   System.out.printf("%-20s", idPronostico);
                System.out.printf("%-20s", part);
                System.out.printf("%-20s", eq1);
                System.out.printf("%-20s", resultado);
                System.out.printf("%-20s %n", eq2);*/

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pronosticos;
    }
}

