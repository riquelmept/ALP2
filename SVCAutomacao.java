

package svcautomacao;


import Classes.Cliente;
import DAO.ClienteDAO;
import DAO.ProdutoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SVCAutomacao {
    
    public static void main(String[] args) {
       Cliente c =  new Cliente();
       c.setCodcliente(1);
       c.setNome("x");
       c.setTelefone("3232");
       
      
       
       
       ClienteDAO dao =  new ClienteDAO("svc","root");
        try {
            dao.deleta(1);
        } catch (SQLException ex) {
            Logger.getLogger(SVCAutomacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
        
        
        
        
        
        
    }
     
    
    

  
}
    



   
    

