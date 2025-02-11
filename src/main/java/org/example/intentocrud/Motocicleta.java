package org.example.intentocrud;

public class Motocicleta extends Vehiculo {
    private boolean deportiva;

    public Motocicleta(int id, int idPersona, String tipo, String modelo, boolean deportiva) {
        super(id, idPersona, tipo, modelo);
        this.deportiva = deportiva;
    }

    @Override
    public String toString() {
        return "Es deportiva: " + deportiva + "tipo:" + tipo + ", modelo " + modelo +  '}';
    }
}
