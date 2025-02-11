package org.example.intentocrud;

public class Vehiculo {
    protected int id;
    protected int idPersona;
    protected String tipo;
    protected String modelo;

    public Vehiculo(int id, int idPersona, String tipo, String modelo) {
        this.id = id;
        this.idPersona = idPersona;
        this.tipo = tipo;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", idPersona=" + idPersona + ", tipo='" + tipo + '\'' + ", modelo='" + modelo + '\'' + '}';
    }
}
