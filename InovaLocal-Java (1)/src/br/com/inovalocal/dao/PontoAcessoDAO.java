package br.com.inovalocal.dao;

import br.com.inovalocal.model.PontoAcesso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PontoAcessoDAO {
    public boolean inserir(PontoAcesso p) {
        String sql = "INSERT INTO PontoAcesso (idComunidade, local, status, bandaDisponivel) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexao.obter();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, p.getIdComunidade());
            ps.setString(2, p.getLocal());
            ps.setString(3, p.getStatus());
            ps.setDouble(4, p.getBandaDisponivel());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    public List<PontoAcesso> listarTodos() {
        List<PontoAcesso> lista = new ArrayList<>();
        String sql = "SELECT id, idComunidade, local, status, bandaDisponivel FROM PontoAcesso ORDER BY id";
        try (Connection con = Conexao.obter();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                PontoAcesso p = new PontoAcesso(
                        rs.getInt("id"),
                        rs.getInt("idComunidade"),
                        rs.getString("local"),
                        rs.getString("status"),
                        rs.getDouble("bandaDisponivel")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }
}