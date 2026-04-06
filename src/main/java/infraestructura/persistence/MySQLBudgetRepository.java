/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura.persistence;

import aplicacion.IBudgetRepository;
import dominio.Transaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLBudgetRepository implements IBudgetRepository {
    @Override
    public void guardar(Transaccion t) {
        String sql = "INSERT INTO transacciones (descripcion, monto, fecha, tipo) VALUES (?,?,?,?)";
        try (Connection conn = DatabaseConnection.getInstance();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getDescripcion());
            ps.setDouble(2, t.getMonto());
            ps.setDate(3, java.sql.Date.valueOf(t.getFecha()));
            ps.setString(4, t.getClass().getSimpleName().toUpperCase());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public List<Transaccion> obtenerTodas() {
        List<Transaccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM transacciones";
        try (Connection conn = DatabaseConnection.getInstance();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                // Aplicación de un FACTORY simple para instanciar según el tipo
                lista.add(TransactionFactory.create(
                    rs.getString("tipo"),
                    rs.getString("descripcion"),
                    rs.getDouble("monto"),
                    rs.getDate("fecha").toLocalDate()
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }
}
