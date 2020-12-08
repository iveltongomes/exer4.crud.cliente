
package controller;

import java.util.ArrayList;
import model.bean.Cliente;
import model.dao.ClienteDAO;



public class clienteController {
    
    public void create(String nome,String email,String CPF,String telefone,String dataaniversario){
        
        Cliente cliente = new Cliente();
        
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setCpf(CPF);
        cliente.setTelefone(telefone);
        cliente.setdataaniversario(dataaniversario);
        
      
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.create(cliente);
    }
    public ArrayList <Cliente> read(){
       ClienteDAO clienteDAO = new ClienteDAO(); 
        return clienteDAO.read();
    }
    
   public void update (int id,String nome,String email,String cpf,String telefone,String dataaniversario){
        
         Cliente cliente = new Cliente();
        
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);
        cliente.setdataaniversario(dataaniversario);
        
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.update(cliente);
        
    }
   
   public void delete (int id){
       
         Cliente cliente = new Cliente();
         ClienteDAO clienteDAO = new ClienteDAO();
         
         cliente.setId(id);
         
         clienteDAO.delete(cliente);
   }
   
   public ArrayList<Cliente> getlistaclientesnome (String nome){
        ClienteDAO clienteDAO = new ClienteDAO(); 
        return clienteDAO.getlistaclientesnome(nome);
   }
}
