package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class Equipo {

    private String nombre;

    @Override
    public String toString() {
        return
                nombre;
    }
}

