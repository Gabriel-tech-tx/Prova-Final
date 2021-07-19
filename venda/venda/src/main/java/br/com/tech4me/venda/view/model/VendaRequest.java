package br.com.tech4me.venda.view.model;

public class VendaRequest {
    private String nome;
    private int quant;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuant() {
        return quant;
    }
    public void setQuant(int quant) {
        this.quant = quant;
    }
}
