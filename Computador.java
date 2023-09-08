
package Classes;

import classesBase.SwingColumn;
import javax.swing.table.DefaultTableCellRenderer;


public class Computador {
      @SwingColumn(description="Cod",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")int cod;
      @SwingColumn(description="Processador",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")String processador;
      @SwingColumn(description="Memória",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")String memoria;
      @SwingColumn(description="PlacaVideo",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")String placaVideo;
      @SwingColumn(description="Fonte",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")String fonte;
      @SwingColumn(description="Disco Rígido",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")String discoRigido;
       @SwingColumn(description="Preco",renderer=DefaultTableCellRenderer.class,
     colorOfBackgound="")Double preco;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getPlacaVideo() {
        return placaVideo;
    }

    public void setPlacaVideo(String placaDeVideo) {
        this.placaVideo = placaDeVideo;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getDiscoRigido() {
        return discoRigido;
    }

    public void setDiscoRigido(String discoRigido) {
        this.discoRigido = discoRigido;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

   
    
    
}
