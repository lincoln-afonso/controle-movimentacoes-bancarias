package br.com.linctech.dominio;

import java.io.Serializable;

import br.com.linctech.dominio.Cliente;
import br.com.linctech.auxiliar.DadoInvalidoException;
import br.com.linctech.auxiliar.DadoNaoInformadoException;

/**
 * <h1>Cliente</h1> Especifica os dados e os comportamentos de uma conta
 * bancária.
 * 
 * @author AFONSO, Lincoln
 * @since Abril/2023
 * @version v 1.0
 */
public class Conta implements Serializable, Comparable<Conta> {
    private static final long serialVersionUID = 1L;
    private int numeroConta;
    private Cliente cliente;
    private double saldo;

    public Conta() {
    }

    public Conta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Conta(Cliente cliente, int numeroConta)
            throws DadoInvalidoException, DadoNaoInformadoException, NumberFormatException {
        this.setCliente(cliente);
        this.saldo = 0;
        this.numeroConta = numeroConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta [cliente=" + cliente + ", numeroConta=" + numeroConta + ", saldo=" + saldo + "]\n";
    }

    @Override
    public int compareTo(Conta conta) {

        if (this.getCliente().getNumeroCliente() > conta.getCliente().getNumeroCliente())
            return -1;

        else if (this.getCliente().getNumeroCliente() < conta.getCliente().getNumeroCliente())
            return 1;

        return 0;
    }

    public void sacar(String valor) throws Exception {
        double valorSaque = Double.parseDouble(valor);

        if (valor.isEmpty())
            throw new DadoNaoInformadoException("O valor do depósito não foi informado!");

        if (valorSaque <= 0)
            throw new DadoInvalidoException("O valor do saque deve ser maior que zero!");
        if (valorSaque > this.saldo)
            throw new Exception("O valor do saque é maior do que o que está em conta!");

        this.saldo -= valorSaque;

    }

    public void depositar(String valor) throws DadoNaoInformadoException, NumberFormatException, DadoInvalidoException {
        double valorDeposito = Double.parseDouble(valor);

        if (valor.isEmpty())
            throw new DadoNaoInformadoException("O valor do depósito não foi informado!");

        if (valorDeposito <= 0)
            throw new DadoInvalidoException("O valor do depósito deve ser maior que zero!");

        this.saldo += valorDeposito;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numeroConta;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Conta other = (Conta) obj;

        if (numeroConta != other.numeroConta)
            return false;
        return true;
    }
}
