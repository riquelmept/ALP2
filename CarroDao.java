
package DAO;

import Classes.Carro;
import classesBase.AcessoMySQL;
import java.sql.SQLException;


public class CarroDao extends AcessoMySQL {
    
    public CarroDao(String nomeBanco, String usuario) {
        super(nomeBanco, usuario);
    }

  
    public void insere(Carro c) throws SQLException{
          this.getConnection();
          c.setCodigoCarro(this.GetNextId("carro", "codigocarro"));
          String sql= "insert into carro(codigocarro,modelo,fabricante,anofabricacao,portas,"
                  + "tipocombustivel,valor) values(?,?,?,?,?,?,?)";
          this.executeCommand(sql, c.getCodigoCarro(),c.getModelo(),c.getFabricante(),
          c.getAnoFabricacao(),c.getPortas(),c.getTipoCombustivel(),c.getValor());
          
    }
    
    public void muda(Carro c) throws SQLException{
        this.getConnection();
         String sql = "update carro set codigocarro = ?, modelo = ?,"+
                "fabricante = ?, anofabricacao= ? ,portas = ?, tipocombustivel = ?,valor = ?";
        this.executeCommand(sql, c.getCodigoCarro(),c.getModelo(),c.getFabricante(),
          c.getAnoFabricacao(),c.getPortas(),c.getTipoCombustivel(),c.getValor());
    }
    
    public void deleta(int codigocarro) throws SQLException{
        this.getConnection();
        String sql = "delete from  carro where codigocarro =?";
        this.executeCommand(sql, codigocarro);
        
    }
    
    
}
