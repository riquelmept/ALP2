
package DAO;

import Classes.Produto;
import classesBase.AcessoMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class ProdutoDAO extends AcessoMySQL {
    
    public ProdutoDAO(String nomeBanco, String usuario) {
        super(nomeBanco, usuario);
    //}

    //public ProdutoDAO(String svc, String root) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void insere(Produto p) throws SQLException{
        this.getConnection();
        p.setCodproduto(this.GetNextId("produto", "codproduto"));
        String sql = "insert into produto(codproduto,nome,"+"preco,quantidade,"
                + "codigobarra) values(?,?,?,?,?)";
                this.executeCommand(sql,p.getCodproduto(),p.getNome
            (),p.getPreço(),p.getQuantidade(),p.getCodigobarra());
                
        
        
        
        
        /*String sql = "insert into produto(codproduto,nome,"+"preco,quantidade,"
                + "codigobarra) values("
                +p.getCodproduto()+",'"+
                p.getNome()+"',"+
                p.getPreço()+","+
                p.getQuantidade()+",'"+
                p.getCodigobarra()+"')";
               System.out.println(sql);
               //this.executeCommand(sql);*/
        
                

    }
    public void atualiza(Produto p) throws SQLException{
        this.getConnection();
        String sq1= "update produto set nome = ?,preco= ?,"
                + "quantidade = ?,codigobarra = ? where codproduto = ?";
        this.executeCommand(sq1, p.getNome(),p.getPreço(),p.getQuantidade(),
                p.getCodigobarra(),p.getCodproduto());
    }
    
    public void apagar(int codigo) throws SQLException{
        this.getConnection();
        String sql = "delete from produto where codproduto = ?";
        this.executeCommand(sql, codigo);
    }
    
    public List<Produto> listarTodosProdutos() throws SQLException{
        List listaProdutos = new LinkedList<Produto>();
        String sql= "select * from produto order by codproduto desc";
        this.executeQuery(sql);
        ResultSet rs = this.executeQuery(sql);
        while(rs.next()){
            listaProdutos.add(populateProduto(rs));
            
        }
        
        
        return(listaProdutos);
    }
    
     
    public List<Produto> listarTodosProdutosPorNome(String nome) throws SQLException{
        List listaProdutos = new LinkedList<Produto>();
        String sql= "select * from produto where nome like '%"+nome+"%'";
        ResultSet rs = this.executeQuery(sql);
        this.executeQuery(sql);
 
        while(rs.next()){
            listaProdutos.add(populateProduto(rs));
        }
        
        
        return(listaProdutos);
    }      
      


    private Object populateProduto(ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        produto.setCodproduto(rs.getInt("codproduto"));
        produto.setNome(rs.getString("nome"));
        produto.setPreço(rs.getDouble("preco"));
        produto.setQuantidade(rs.getInt("quantidade"));
        produto.setCodigobarra(rs.getString("codigobarra"));
        return(produto);
       
    }

    
    
    
}
