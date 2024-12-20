/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa
 */
public class ProdutoDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ProdutoDTO> listaProdutos = new ArrayList<>();

    public void cadastrarProduto (ProdutoDTO produtoDto) {

        String sql = "insert into produto(nome, preco, quantidade, tipo)values(?, ?, ?, ?)";

        conn = new Conexao().conectaBd();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produtoDto.getNome());
            pstm.setDouble(2, produtoDto.getPreco());
            pstm.setInt(3, produtoDto.getQuantidade());
            pstm.setString(4, produtoDto.getTipo());
            pstm.execute();
            pstm.close();

        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e + "Cadastrar Produto - DAO");
        }

    }

    public ArrayList<ProdutoDTO> pesquisarProduto () {

        String sql = "select * from produto";
        conn = new Conexao().conectaBd();

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ProdutoDTO produtoDto = new ProdutoDTO();
                produtoDto.setId(rs.getInt("id"));
                produtoDto.setNome(rs.getString("nome"));
                produtoDto.setPreco(rs.getDouble("preco"));
                produtoDto.setQuantidade(rs.getInt("quantidade"));
                produtoDto.setTipo(rs.getString("tipo"));

                listaProdutos.add(produtoDto);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Erro Pesquisar Produto - DAO.");
        }

        return listaProdutos;
    }

    public void atualizarProduto (ProdutoDTO produtoDto) {
        String sql = "update produto set nome = ?, preco = ?, quantidade = ?, tipo = ? where id = ?";

        conn = new Conexao().conectaBd();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produtoDto.getNome());
            pstm.setDouble(2, produtoDto.getPreco());
            pstm.setInt(3, produtoDto.getQuantidade());
            pstm.setString(4, produtoDto.getTipo());
            pstm.setInt(5, produtoDto.getId());
            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Erro ao Atualizar Produto - DAO.");
        }
    }

    public void excluirProduto(ProdutoDTO produtoDto) {
        String sql = "delete from produto WHERE id = ?";

        conn = new Conexao().conectaBd();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, produtoDto.getId());
            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Erro ao Excluir Produto - DAO. ");
        }
    }

}

