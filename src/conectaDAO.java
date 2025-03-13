
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection connectDB(){
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11","root","W<Uxg8fx5Y~)ce1$"); // insira o tipo de usuario e a senha no segundo e na terceira casa.
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Erro: Driver JDBC nao encontrado!.");
        }
        return conn;
    }
    
    public void desconectarDB(Connection conn){
        try{
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Banco de dados desconectado.");
            }
        }catch(SQLException ex){
            System.out.println("Nao foi possivel desconectar do banco dados.");
        }
    }
    
}
