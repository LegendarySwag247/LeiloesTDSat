/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        conectaDAO dao = new conectaDAO();
        
        try{
            conn = dao.connectDB();
            String sql = "INSERT INTO produtos (nome, valor, status) VALUES(?,?,?)";
            prep = conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            
            prep.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro foi realizado com sucesso!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao connectar! " + ex.getMessage());
        }finally{
            dao.desconectarDB(conn);
        }
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        conectaDAO dao = new conectaDAO();
        
        try{
            conn = dao.connectDB();
            String sql = "SELECT * FROM produtos";
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();
            
            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));

                listagem.add(produto);
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao connectar! " + ex.getMessage());
        }finally{
            dao.desconectarDB(conn);
        }
        return listagem;
    }
    
    
    
        
}

