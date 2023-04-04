package br.com.linctech.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.linctech.auxiliar.DadoInvalidoException;
import br.com.linctech.auxiliar.DadoNaoInformadoException;
import br.com.linctech.auxiliar.TipoOperacao;

public class HistoricoMovimentacao implements Serializable, Comparable<HistoricoMovimentacao> {
    private static final long serialVersionUID = 1L;
    private Conta conta;
    private double valor;
    private TipoOperacao operacao;
    LocalDate dataMovimentacao;

    public HistoricoMovimentacao() {};

    public HistoricoMovimentacao(Conta conta, String valor, String operacao, String dataMovimentacao)
            throws DadoNaoInformadoException, DadoInvalidoException, IllegalArgumentException, NumberFormatException {
        this.setConta(conta);
        this.setValor(valor);
        this.setOperacao(operacao);
        this.setDataMovimentacao(dataMovimentacao);
    }   

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(String valor) throws DadoNaoInformadoException, DadoInvalidoException {
        double valorMovimentacao;

        if (valor.isEmpty())
            throw new DadoNaoInformadoException("Valor não informado!");

        valorMovimentacao = Double.parseDouble(valor);
        if (valorMovimentacao <= 0)
            throw new DadoInvalidoException("Valor inválido!");
        this.valor = valorMovimentacao;
    }

    public TipoOperacao getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) throws IllegalArgumentException, DadoNaoInformadoException {
        if (operacao.isEmpty())
            throw new DadoNaoInformadoException("O tipo de operação não foi informado!");
        this.operacao = TipoOperacao.valueOf(operacao);
    }

    private LocalDate converterData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormatada = LocalDate.parse(data, formatter);
        return dataFormatada;
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(String dataMovimentacao) throws NumberFormatException, DadoNaoInformadoException {
        LocalDate data;

        if (dataMovimentacao.isEmpty())
            throw new DadoNaoInformadoException("Data não informada!");

        data = this.converterData(dataMovimentacao);
        this.dataMovimentacao = data;
    }

    @Override
    public int compareTo(HistoricoMovimentacao movimentacao) {
        return this.getConta().toString().compareTo(movimentacao.getDataMovimentacao().toString());
    }

    @Override
    public String toString() {
        return "Movimentacao [conta=" + conta + ", dataMovimentacao=" + dataMovimentacao + ", operacao=" + operacao
                + ", valor=" + valor + "]\n";
    }
}   