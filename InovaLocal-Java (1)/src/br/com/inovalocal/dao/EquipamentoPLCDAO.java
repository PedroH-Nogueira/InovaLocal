package br.com.inovalocal.dao;

import br.com.inovalocal.model.EquipamentoPLC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoPLCDAO {
    public boolean inserir(EquipamentoPLC e) {
        String sql = "INSERT INTO EquipamentoPLC (modelo, fabricante, capacidadeMbps, emUso) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexao.obter();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getModelo());
            ps.setString(2, e.getFabricante());
            ps.setInt(3, e.getCapacidadeMbps());
            ps.setBoolean(4, e.isEmUso());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return false;
        }
    }

    public List<EquipamentoPLC> listarTodos() {
        List<EquipamentoPLC> lista = new ArrayList<>();
        String sql = "SELECT id, modelo, fabricante, capacidadeMbps, emUso FROM EquipamentoPLC ORDER BY id";
        try (Connection con = Conexao.obter();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                EquipamentoPLC e = new EquipamentoPLC(
                        rs.getInt("id"),
                        rs.getString("modelo"),
                        rs.getString("fabricante"),
                        rs.getInt("capacidadeMbps"),
                        rs.getBoolean("emUso")
                );
                lista.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return lista;
    }
}