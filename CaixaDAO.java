
package DAO;

import Classes.Caixa;
import classesBase.AcessoMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CaixaDAO extends AcessoMySQL {
    
    public CaixaDAO(String nomeBanco, String usuario) {
        super(nomeBanco, usuario);
    }
    public void iniciaCaixa(double valor) throws SQLException{
    int codigoDoCaixa = this.GetNextId("caixa", "codcaixa");
    String sql = "insert into caixa(codcaixa,valorinicial) values(?,?)";
    this.executeCommand(sql, codigoDoCaixa,valor);
    
     
    }
    public int quantidadeCaixaAberto() throws SQLException{
        String sql = "SELECT COUNT(codcaixa) as quantidade from caixa  where aberto = 1";
        this.executeQuery(sql);
        ResultSet rs = this.executeQuery(sql);
        if(rs.next()){
            return(rs.getInt("quantidade"));
                    
        }else
            return(0);
    }
    public Caixa lerCaixa() throws SQLException{
        String sql = "select * from caixa where aberto = 1";
        ResultSet rs = this.executeQuery(sql);
        if(rs.next()){
            return(populateCaixa(rs));
            
        }else
            return(null);   
    }
    
     private Caixa populateCaixa(ResultSet rs) throws SQLException {
         Caixa caixa = new Caixa();
         caixa.setCodcaixa(rs.getInt("codcaixa"));
         caixa.setDataabertura(rs.getDate("dataabertura"));
         caixa.setDatafechamento(rs.getDate("datafechamento"));
         caixa.setValorinicial(rs.getDouble("valorinicial"));
         caixa.setValorfinal(rs.getDouble("valorfinal"));
         caixa.setVendas(rs.getDouble("vendas"));
         caixa.setDeposito(rs.getDouble("deposito"));
         caixa.setSuprimentos(rs.getDouble("suprimento"));
         caixa.setDiferença(rs.getDouble("diferença"));
         caixa.setAberto(rs.getInt("aberto"));
         return(caixa);
     }
   
    
    
    public void fechaCaixa(Caixa c) throws SQLException{
        String sql = "update caixa set datafechamento = ?, valorfinal = ?, diferença = ? ,aberto = ? where codcaixa= ?";
        this.executeCommand(sql,c.getDatafechamento(),c.getValorfinal(),c.getDiferença(),c.getAberto(),c.getCodcaixa());
    }
    
    public void deposito(double valor) throws SQLException{
        String sql = "update caixa set deposito = (deposito + ?)where aberto = 1";
        this.executeCommand(sql, valor);
    }
  
    public void suprimento(double valor) throws SQLException{
        String sql = "update caixa set suprimento = (suprimento + ?) where aberto =1";
        this.executeCommand(sql, valor);
        
    }

   
    
    
    
}
