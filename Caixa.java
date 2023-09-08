
package Classes;

import java.util.Date;


public class Caixa {
   private int codcaixa;
   private Date dataabertura;
   private Date datafechamento;
   private double valorinicial;
   private double valorfinal; 
   private double vendas;
   private double deposito;
   private double suprimento;
   private double diferença;
   private int aberto; 

    public Caixa() {
       
    }

    public int getCodcaixa() {
        return codcaixa;
    }

    public void setCodcaixa(int codcaixa) {
        this.codcaixa = codcaixa;
    }

    public Date getDataabertura() {
        return dataabertura;
    }

    public void setDataabertura(Date dataabertura) {
        this.dataabertura = dataabertura;
    }

    public Date getDatafechamento() {
        return datafechamento;
    }

    public void setDatafechamento(Date datafechamento) {
        this.datafechamento = datafechamento;
    }

    public double getValorinicial() {
        return valorinicial;
    }

    public void setValorinicial(double valorinicial) {
        this.valorinicial = valorinicial;
    }

    public double getValorfinal() {
        return valorfinal;
    }

    public void setValorfinal(double valorfinal) {
        this.valorfinal = valorfinal;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    public double getDiferença() {
        return diferença;
    }

    public void setDiferença(double diferença) {
        this.diferença = diferença;
    }

    public int getAberto() {
        return aberto;
    }

    public void setAberto(int aberto) {
        this.aberto = aberto;
    }

    public double getSuprimentos() {
        return suprimento;
    }

    public void setSuprimentos(double suprimentos) {
        this.suprimento = suprimentos;
    }
    
  
  
    
    
}
