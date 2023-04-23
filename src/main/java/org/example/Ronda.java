package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Ronda {
    private int id;
    private List<Partido> rondaPartido;


    public Ronda(int id) {
        this.id = id;
        rondaPartido = new ArrayList<>();
    }

    public void agregarPartido(Partido partido){
        this.rondaPartido.add(partido);
    }

    @Override
    public String toString() {
        return "Ronda{" +
                "id=" + id +
                ", rondaPartido=" + rondaPartido +
                '}';
    }
}
