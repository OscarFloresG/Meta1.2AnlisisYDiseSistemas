package org.example.intentocrud;

public class VehiculoMaritimo extends Vehiculo {
    private int capacidad;

    public VehiculoMaritimo(int id, int idPersona, String tipo, String modelo, int capacidad) {
        super(id, idPersona, tipo, modelo);
        this.capacidad = capacidad;
    }
}
