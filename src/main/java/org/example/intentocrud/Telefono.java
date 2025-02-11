package org.example.intentocrud;

public class Telefono {
    private int id;
    private int idPersona;
    private String numero;

    public Telefono(int id, int idPersona, String numero) {
        this.id = id;
        this.idPersona = idPersona;
        this.numero = numero;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}

