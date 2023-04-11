package br.com.linctech.auxiliar;

import java.util.Set;

import br.com.linctech.dominio.Cliente;
import br.com.linctech.dominio.Conta;
import br.com.linctech.dominio.HistoricoMovimentacao;

public interface FuncaoSistema {

    public abstract boolean cadastrarCliente(Set<Cliente> setClientes);

    public abstract boolean cadastrarConta(Set<Conta> setContas, Set<Cliente> setClientes);

    public abstract void listarContas(Set<Conta> setContas, Set<HistoricoMovimentacao> setHistoricoMovimentacao);

    public abstract boolean excluirConta(Set<Conta> setContas, Set<HistoricoMovimentacao> setHistoricoMovimentacao);

}