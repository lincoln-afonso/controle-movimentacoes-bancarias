package br.com.linctech.auxiliar;

import java.util.List;
import java.util.Set;

import br.com.linctech.dominio.Cliente;
import br.com.linctech.dominio.Conta;
import br.com.linctech.dominio.HistoricoMovimentacao;

public interface FuncaoSistema {

        public abstract boolean cadastrarCliente(Set<Cliente> setClientes);

        public abstract boolean cadastrarConta(Set<Conta> setContas, Set<Cliente> setClientes);

        public abstract void listarContas(Set<Conta> setContas, List<HistoricoMovimentacao> listHistoricoMovimentacao)
                        throws ColecaoVaziaException;

        public boolean realizarDeposito(Set<Conta> setContas, List<HistoricoMovimentacao> listHistoricoMovimentacao)
                        throws ColecaoVaziaException;

        public boolean realizarSaque(Set<Conta> setContas, List<HistoricoMovimentacao> listHistoricoMovimentacao)
                        throws ColecaoVaziaException;

        public abstract void listarMovimentacoes(List<HistoricoMovimentacao> listHistoricoMovimentacao, Conta conta);

        public abstract boolean excluirConta(Set<Conta> setContas,
                        List<HistoricoMovimentacao> listHistoricoMovimentacao) throws ColecaoVaziaException;

        public abstract void excluirMovimentacao(List<HistoricoMovimentacao> listHistoricoMovimentacao, Conta conta);

}