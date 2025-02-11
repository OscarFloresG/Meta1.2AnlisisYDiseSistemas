package org.example.intentocrud;

public class CamionCarga extends Vehiculo {
    private int capacidadCarga;

    public CamionCarga(int id, int idPersona, String tipo, String modelo, int capacidadCarga) {
        super(id, idPersona, tipo, modelo);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return "Capacidad" + capacidadCarga + "tipo " + tipo + ", modelo " + modelo +  '}';
    }
}
