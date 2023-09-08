
package Classes;

import classesBase.SwingColumn;
import javax.swing.table.DefaultTableCellRenderer;


public class Produto {
    @SwingColumn(description="Código",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private int codproduto; 
    
    @SwingColumn(description="Nome",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private String nome; 
    @SwingColumn(description="Preço",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private double preço;
    @SwingColumn(description="Quantidade",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private int quantidade;
    @SwingColumn(description="CodigoBarra",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private String codigobarra;

    public int getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(int codproduto) {
        this.codproduto = codproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    @Override
    public String toString() {
        return "Produto{" + "codproduto=" + codproduto + ", nome=" + nome + ", pre\u00e7o=" + preço + ", quantidade=" + quantidade + ", codigobarra=" + codigobarra + '}';
    }
    
    
    
}
