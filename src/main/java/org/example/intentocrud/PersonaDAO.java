package org.example.intentocrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    public static void insertarPersona(String nombre, String direccion, List<String> telefonos, List<Vehiculo> vehiculos) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "INSERT INTO Personas (nombre, direccion) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, nombre);
        ps.setString(2, direccion);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int idPersona = rs.getInt(1);
            for (String telefono : telefonos) {
                TelefonoDAO.insertarTelefono(idPersona, telefono);
            }
            for (Vehiculo vehiculo : vehiculos) {
                VehiculoDAO.insertarVehiculo(idPersona, vehiculo.getTipo(), vehiculo.getModelo());
            }
        }
        con.close();
    }

    public static List<Persona> obtenerPersonas() throws SQLException {
        Connection con = Database.getConnection();
        String sql = "SELECT * FROM Personas";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Persona> personas = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String direccion = rs.getString("direccion");
            List<String> telefonos = TelefonoDAO.obtenerTelefonos(id);
            List<Vehiculo> vehiculos = VehiculoDAO.obtenerVehiculos(id);
            personas.add(new Persona(id, nombre, direccion, telefonos, vehiculos));
        }
        con.close();
        return personas;
    }

    public static void eliminarPersona(int id) throws SQLException {
        Connection con = Database.getConnection();

        VehiculoDAO.eliminarVehiculos(id);
        TelefonoDAO.eliminarTelefonos(id);

        String sql = "DELETE FROM Personas WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        con.close();
    }

    public static void actualizarPersona(int id, String nombre, String direccion, List<String> telefonos, List<Vehiculo> vehiculos) throws SQLException {
        Connection con = Database.getConnection();

        String sql = "UPDATE Personas SET nombre = ?, direccion = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, direccion);
        ps.setInt(3, id);
        ps.executeUpdate();

        TelefonoDAO.eliminarTelefonos(id);
        for (String telefono : telefonos) {
            TelefonoDAO.insertarTelefono(id, telefono);
        }

        VehiculoDAO.actualizarVehiculos(id, vehiculos);

        con.close();
    }
}
