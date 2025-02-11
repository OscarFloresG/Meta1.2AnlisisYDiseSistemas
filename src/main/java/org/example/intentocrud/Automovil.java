package org.example.intentocrud;

public class Automovil extends Vehiculo {
    private int numeroPuertas;

    public Automovil(int id, int idPersona, String tipo, String modelo, int numeroPuertas) {
        super(id, idPersona, tipo, modelo);
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public String toString() {
        return "Automovil{" + "numeroPuertas=" + numeroPuertas + "tipo " + tipo + ", modelo " + modelo +  '}';
    }
}
