package br.com.tech4me.venda.shered;

public class VendaDto {
    private String id;
    private String nome;
    private Double valorTotal;
    private String produtoVendido;
    private int quant;
    
    public String getId() {
        return id;
    }
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
 public void setId(String id) {
        this.id = id;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public String getProdutoVendido() {
        return produtoVendido;
    }
    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

}
