package org.example.intentocrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefonoDAO {
    public static void insertarTelefono(int idPersona, String telefono) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "INSERT INTO Telefonos (id_persona, telefono) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPersona);
        ps.setString(2, telefono);
        ps.executeUpdate();
        con.close();
    }

    public static List<String> obtenerTelefonos(int idPersona) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "SELECT telefono FROM Telefonos WHERE id_persona = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPersona);
        ResultSet rs = ps.executeQuery();

        List<String> telefonos = new ArrayList<>();
        while (rs.next()) {
            telefonos.add(rs.getString("telefono"));
        }
        con.close();
        return telefonos;
    }

    public static void eliminarTelefonos(int idPersona) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "DELETE FROM Telefonos WHERE id_persona = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPersona);
        ps.executeUpdate();
        con.close();
    }

}
