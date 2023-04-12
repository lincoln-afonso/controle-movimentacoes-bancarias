package br.com.linctech.auxiliar;

import java.util.List;
import java.util.Set;

import br.com.linctech.dominio.Cliente;
import br.com.linctech.dominio.Conta;
import br.com.linctech.dominio.HistoricoMovimentacao;

public interface FuncaoSistema {

        public abstract boolean cadastrarCliente(Set<Cliente> setClientes);

        public abstract boolean cadastrarConta(List<Conta> listContas, Set<Cliente> setClientes);

        public abstract void listarContas(List<Conta> listContas, List<HistoricoMovimentacao> listHistoricoMovimentacao)
                        throws ColecaoVaziaException;

        public boolean realizarDeposito(List<Conta> listContas, List<HistoricoMovimentacao> listHistoricoMovimentacao)
                        throws ColecaoVaziaException;

        public boolean realizarSaque(List<Conta> listContas, List<HistoricoMovimentacao> listHistoricoMovimentacao)
                        throws ColecaoVaziaException;

        public abstract void listarMovimentacoes(List<HistoricoMovimentacao> listHistoricoMovimentacao, Conta conta);

        public abstract boolean excluirConta(List<Conta> listContas,
                        List<HistoricoMovimentacao> listHistoricoMovimentacao) throws ColecaoVaziaException;

        public abstract void excluirMovimentacao(List<HistoricoMovimentacao> listHistoricoMovimentacao, Conta conta);

}