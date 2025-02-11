package org.example.intentocrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {

    public static void insertarVehiculo(int idPersona, String tipo, String modelo) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "INSERT INTO Vehiculos (id_persona, tipo, modelo) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPersona);
        ps.setString(2, tipo);
        ps.setString(3, modelo);
        ps.executeUpdate();
        con.close();
    }

    public static List<Vehiculo> obtenerVehiculos(int idPersona) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "SELECT * FROM Vehiculos WHERE id_persona = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPersona);
        ResultSet rs = ps.executeQuery();

        List<Vehiculo> vehiculos = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String tipo = rs.getString("tipo");
            String modelo = rs.getString("modelo");
            vehiculos.add(new Vehiculo(id, idPersona, tipo, modelo));
        }
        con.close();
        return vehiculos;
    }

    public static void eliminarVehiculos(int idPersona) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "DELETE FROM Vehiculos WHERE id_persona = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPersona);
        ps.executeUpdate();
        con.close();
    }

    public static void actualizarVehiculos(int idPersona, List<Vehiculo> vehiculos) throws SQLException {
        eliminarVehiculos(idPersona);

        for (Vehiculo vehiculo : vehiculos) {
            insertarVehiculo(idPersona, vehiculo.getTipo(), vehiculo.getModelo());
        }
    }
}
