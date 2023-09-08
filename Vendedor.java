
package Classes;

import classesBase.SwingColumn;
import javax.swing.table.DefaultTableCellRenderer;


public class Vendedor {
      @SwingColumn(description="Código",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private int cod;
      @SwingColumn(description="Nome",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")private String nome;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
 
    
}
