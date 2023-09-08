
package DAO;

import Classes.Cliente;
import classesBase.AcessoMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class ClienteDAO extends AcessoMySQL{
    
    public ClienteDAO(String nomeBanco, String usuario) {
        super(nomeBanco, usuario);
    }
    public void insere(Cliente c) throws SQLException{
        this.getConnection();
        c.setCodcliente(this.GetNextId("cliente", "codcliente"));
        String sql= "insert into cliente(codcliente,nome,telefone) values(?,?,?)";
        this.executeCommand(sql,c.getCodcliente(),c.getNome(),c.getTelefone());
        
    }
    public void muda(Cliente c) throws SQLException{
        this.getConnection();
        String sql = "update cliente set nome =?, telefone=? where codcliente=?";
        this.executeCommand(sql,c.getNome(),c.getTelefone(),c.getCodcliente());
    }
    public void deleta(int codcliente) throws SQLException{
        this.getConnection();
        String sql = "delete from cliente where codcliente =?";
        this.executeCommand(sql, codcliente);
    }
    
    public List<Cliente> listarTodosClientes() throws SQLException{ 
        List listaClientes = new LinkedList<Cliente>();
            String sql= "select * from cliente order by codcliente desc";
            this.executeQuery(sql);
            ResultSet rs = this.executeQuery(sql);
            while(rs.next()){
                listaClientes.add(populateCliente(rs));
            }
            
        return(listaClientes);     
    }
     private Object populateCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setCodcliente(rs.getInt("codcliente"));
        cliente.setNome(rs.getString("nome"));
        cliente.setTelefone(rs.getString("telefone"));
        return(cliente);
         
    }
     
      public List<Cliente> listarTodosClientesPorNome(String nome) throws SQLException{
        List listaClientes = new LinkedList<Cliente>();
        String sql= "select * from cliente where nome like '%"+nome+"%'";
        ResultSet rs = this.executeQuery(sql);
        this.executeQuery(sql);
 
        while(rs.next()){
            listaClientes.add(populateCliente(rs));
            
        }
        
        
        return(listaClientes);
    }
}      


  
