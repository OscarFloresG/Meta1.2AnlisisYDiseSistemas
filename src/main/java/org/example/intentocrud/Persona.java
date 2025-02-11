package org.example.intentocrud;

import java.util.List;

public class Persona {
    private int id;
    private String nombre;
    private String direccion;
    private List<String> telefonos;
    private List<Vehiculo> vehiculos;

    public Persona(int id, String nombre, String direccion, List<String> telefonos, List<Vehiculo> vehiculos) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.vehiculos = vehiculos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefonos=" + telefonos +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
