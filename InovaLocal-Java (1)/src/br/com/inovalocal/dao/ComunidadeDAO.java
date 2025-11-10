package br.com.inovalocal.dao;

import br.com.inovalocal.model.Comunidade;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComunidadeDAO {
    public boolean inserir(Comunidade c) {
        String sql = "INSERT INTO Comunidade (nome, localizacao, populacao, situacaoConectividade) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexao.obter();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getLocalizacao());
            ps.setInt(3, c.getPopulacao());
            ps.setString(4, c.getSituacaoConectividade());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    public List<Comunidade> listarTodos() {
        List<Comunidade> lista = new ArrayList<>();
        String sql = "SELECT id, nome, localizacao, populacao, situacaoConectividade FROM Comunidade ORDER BY id";
        try (Connection con = Conexao.obter();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Comunidade c = new Comunidade(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("localizacao"),
                        rs.getInt("populacao"),
                        rs.getString("situacaoConectividade")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }
}