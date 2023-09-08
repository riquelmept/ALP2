
package DAO;

import Classes.Vendedor;
import classesBase.AcessoMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class VendedorDAO extends AcessoMySQL {
    
    public VendedorDAO(String nomeBanco, String usuario) {
        super(nomeBanco, usuario);
    }
   public void insere(Vendedor v) throws SQLException{
      this.getConnection();
      v.setCod(this.GetNextId("vendedor", "cod"));
      String sql = "insert into vendedor(cod, nome) values(?,?)";
      this.executeCommand(sql, v.getCod(),v.getNome());
      
   }
   
   public void muda(Vendedor v) throws SQLException{
       this.getConnection();
        String sql = "update vendedor set nome =? where cod=?";
        this.executeCommand(sql, v.getNome(),v.getCod());
       
   }
    public void deleta(int cod) throws SQLException{
        this.getConnection();
        String sql = "delete from vendedor where cod = ?";
        this.executeCommand(sql, cod);
    }
    
    
    private Object populateVendedor(ResultSet rs) throws SQLException {
        Vendedor vendedor = new Vendedor();
        vendedor.setCod(rs.getInt("cod"));
        vendedor.setNome(rs.getString("nome"));
        return(vendedor);
    
    }
    
     public List<Vendedor> listarTodosVendedores() throws SQLException{
        List listaVendedor = new LinkedList<Vendedor>();
        String sql= "select * from vendedor order by cod desc";
        this.executeQuery(sql);
        ResultSet rs = this.executeQuery(sql);
        while(rs.next()){
            listaVendedor.add(populateVendedor(rs));
            
        }
        
        
        return(listaVendedor);
    }
     
      public List<Vendedor> listarTodosVendedoresNome(String nome) throws SQLException{
        List listaVendedor = new LinkedList<Vendedor>();
        String sql= "select * from vendedor where nome like '%"+nome+"%'";
        this.executeQuery(sql);
        ResultSet rs = this.executeQuery(sql);
        while(rs.next()){
            listaVendedor.add(populateVendedor(rs));
    
        }
        return(listaVendedor);
      }
}

  
