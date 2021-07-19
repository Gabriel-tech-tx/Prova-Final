package br.com.tech4me.venda.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("venda")
public class Venda {
    @Id
    private String id;
    private String nome;
    private Double valorTotal;
    private String produtoVendido;
    private int quant;
   
    public String getProdutoVendido() {
        return produtoVendido;
    }
    public int getQuant() {
        return quant;
    }
    public void setQuant(int quant) {
        this.quant = quant;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
    }
    public String getQuantVendido() {
        return quantVendido;
    }
    public void setQuantVendido(String quantVendido) {
        this.quantVendido = quantVendido;
    }
    private String quantVendido;
    
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal, String string) {
        this.valorTotal = valorTotal;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    

}
