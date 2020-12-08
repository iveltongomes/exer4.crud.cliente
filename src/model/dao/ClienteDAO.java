
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;

public class ClienteDAO {

    
    public void create (Cliente cliente) {
    
     Connection con =ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement(" INSERT INTO cliente (nome,email,CPF,telefone,dataaniversario) values (?,?,?,?,?) ");
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getEmail());
            stmt.setString(3,cliente.getCpf());
            stmt.setString(4,cliente.getTelefone());
            stmt.setString(5,cliente.getdataaniversario());
            
            con.setAutoCommit(false);// interrompe o autocommit que vem por deafault
            stmt.executeUpdate();
            
            con.commit();// executa as alteraçoes no bd
            JOptionPane.showMessageDialog(null,"SALVO COM SUCESSO");
        }
        catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"erro ao salvar"+ex);
             Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,null,ex);
             
         try {
             con.rollback();// em caso de erro ele desfaz as operaçoes realizadas
         } catch (SQLException ex1) {
            System.out.println(" ERRO AO SALVAR !!!");
         }
        }finally{
            
        }
}
    public ArrayList <Cliente> read(){
        Connection con =ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
       ResultSet rs = null;
       
       ArrayList <Cliente> ListaClientes = new ArrayList<>();
       
       try{
           stmt = con.prepareStatement("SELECT * FROM Cliente ORDER BY id");
           rs = stmt.executeQuery();
           
           while(rs.next()){
               Cliente cliente = new Cliente();
               cliente.setId(rs.getInt("id"));
               cliente.setNome(rs.getString("nome"));
               cliente.setEmail(rs.getString("email"));
               cliente.setCpf(rs.getString("cpf"));
               cliente.setTelefone(rs.getString("email"));
               cliente.setdataaniversario(rs.getString("email"));
               
               ListaClientes.add(cliente);
           }
           
       }
       catch (SQLException ex){
           JOptionPane.showMessageDialog(null,"erro ao ler os clientes","erro",JOptionPane.ERROR_MESSAGE);
       }
       finally{
           ConnectionFactory.closeConnection(con, stmt, rs);
       }
       
       
       return ListaClientes;
    }
   public void update (Cliente cliente){
           Connection con =ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("update cliente set nome = ?,email = ?,cpf = ?,telefone = ?,dataaniversario = ? where id = ?");
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getEmail());
            stmt.setString(3,cliente.getCpf());
            stmt.setString(4,cliente.getTelefone());
            stmt.setString(5,cliente.getdataaniversario());
            stmt.setInt(6,cliente.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "atualizado com sucesso : ");
    }   
        catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"erro ao atualizar: " + ex);
        }
        finally{
            
    }
    }
  
    public void delete (Cliente cliente){
         Connection con =ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
          stmt = con.prepareStatement("DELETE FROM cliente where id = ?");   
          stmt.setInt(1,cliente.getId());
          stmt.executeUpdate();
          
          JOptionPane.showMessageDialog(null, "excluido com sucesso : ");
            
        }
        
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao excluir " + ex);
        }
        finally{
            
        }
    }
    
    public ArrayList <Cliente> getlistaclientesnome (String nome){
        
        Connection con =ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
         ResultSet rs = null;
       
       ArrayList <Cliente> ListaClientes = new ArrayList<>();
       
       try{
      
      stmt = con.prepareStatement("SELECT * FROM cliente WHERE nome like ? ORDER BY id");
       stmt.setString(1,"%" + nome + "%");
           rs = stmt.executeQuery();
           
           while(rs.next()){
               
               Cliente cliente = new Cliente();
               cliente.setId(rs.getInt("id"));
               cliente.setNome(rs.getString("nome"));
               cliente.setEmail(rs.getString("email"));
               cliente.setCpf(rs.getString("cpf"));
               cliente.setTelefone(rs.getString("telefone"));
               cliente.setdataaniversario(rs.getString("dataniversario"));
               ListaClientes.add(cliente);
            
           }
          
       }
              catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao ler os clientes  ","erro" ,JOptionPane.ERROR_MESSAGE);
        }
       finally{
         ConnectionFactory.closeConnection(con, stmt, rs);
       }
       return ListaClientes;
    }
}
