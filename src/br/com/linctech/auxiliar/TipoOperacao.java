package br.com.linctech.auxiliar;

public enum TipoOperacao{

    CREDITO("Crédito"),
    DEBITO("Débito");
  
    private String descricao;
  
    TipoOperacao(String descricao) {
       this.descricao = descricao;
    }
  
    public String getDescricao() {
       return descricao;
    }
  }