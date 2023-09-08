
package DAO;

import Classes.Computador;
import classesBase.AcessoMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class ComputadorDAO extends AcessoMySQL {
    
    public ComputadorDAO(String nomeBanco, String usuario) {
        super(nomeBanco, usuario);
    }
    
     public void insere(Computador c) throws SQLException{
        this.getConnection();
        c.setCod(this.GetNextId("computador", "cod"));
        String sql = "insert into computador(cod,processador,"+"memoria,placavideo,"
                + "fonte, discorigido,preco) values(?,?,?,?,?,?,?)";
                this.executeCommand(sql,c.getCod(),c.getProcessador(),c.getMemoria(),c.getPlacaVideo(),c.getFonte(),
                        c.getDiscoRigido(),c.getPreco());

    }
      public void atualiza(Computador c) throws SQLException{
        this.getConnection();
        String sq1= "update computador set processador = ?,memoria = ?,"
                + "placavideo = ?,fonte = ?,discorigido = ?,preco = ? where cod = ?";
        this.executeCommand(sq1,c.getProcessador(),c.getMemoria(),c.getPlacaVideo(),c.getFonte(),
                        c.getDiscoRigido(),c.getPreco(),c.getCod());
    }
      
      
        public void apagar(int cod) throws SQLException{
        this.getConnection();
        String sql = "delete from computador where cod = ?";
        this.executeCommand(sql, cod);
    }
        public List<Computador> listarTodosComputadores() throws SQLException{
        List listaComputadores = new LinkedList<Computador>();
        String sql= "select * from computador order by cod desc";
        this.executeQuery(sql);
        ResultSet rs = this.executeQuery(sql);
        while(rs.next()){
            listaComputadores.add(populateComputador(rs));
        }
           return(listaComputadores);
    }
        
        
        public List<Computador> listarTodosComputadoresNome(String processador) throws SQLException{
        List listaComputadores = new LinkedList<Computador>();
        String sql= "select * from computador where processador like '%"+processador+"%'";
        ResultSet rs = this.executeQuery(sql);
        this.executeQuery(sql);
 
        while(rs.next()){
            listaComputadores.add(populateComputador(rs));
        }
        
        
        return(listaComputadores);
    }
        
         private Object populateComputador(ResultSet rs) throws SQLException {
        Computador computador = new Computador();
        computador.setCod(rs.getInt("cod"));
        computador.setProcessador(rs.getString("processador"));
        computador.setMemoria(rs.getString("memoria"));
        computador.setPlacaVideo(rs.getString("placavideo"));
        computador.setDiscoRigido(rs.getString("discorigido"));
        computador.setFonte(rs.getString("fonte"));
        computador.setPreco(rs.getDouble("preco"));
       
        return(computador);
       
    }
        
        
}
        