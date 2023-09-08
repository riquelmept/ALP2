
package Classes;

import classesBase.SwingColumn;
import javax.swing.table.DefaultTableCellRenderer;


public class Cliente {
     @SwingColumn(description="Código",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private int codcliente;
     @SwingColumn(description="Nome",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private String nome; 
     @SwingColumn(description="Telefone",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private String telefone;

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codcliente=" + codcliente + ", nome=" + nome + ", telefone=" + telefone + '}';
    }
    
    
    
    
}
