package br.com.linctech.auxiliar;

import br.com.linctech.dominio.Conta;

public interface RealizarOperacao {
    
    public abstract boolean sacar(Conta conta);

    public abstract boolean depositar(Conta conta);
}