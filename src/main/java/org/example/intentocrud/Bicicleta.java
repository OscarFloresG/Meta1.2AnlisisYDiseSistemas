package org.example.intentocrud;

public class Bicicleta extends Vehiculo {
    private boolean esElectrica;

    public Bicicleta(int id, int idPersona, String tipo, String modelo, boolean esElectrica) {
        super(id, idPersona, tipo, modelo);
        this.esElectrica = esElectrica;
    }

    @Override
    public String toString() {
        return "Electrica" + esElectrica + "tipo " + tipo + ", modelo " + modelo +  '}';
    }
}
