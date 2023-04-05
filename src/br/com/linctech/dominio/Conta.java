package br.com.linctech.dominio;

import java.util.Random;

import br.com.linctech.dominio.Cliente;
import br.com.linctech.auxiliar.DadoInvalidoException;
import br.com.linctech.auxiliar.DadoNaoInformadoException;

/**
 * <h1>Cliente</h1>
 * Especifica os dados e os comportamentos de uma conta bancária.
 * @author AFONSO, Lincoln
 * @since Abril/2023
 * @version v 1.0
 */
public class Conta {
    private int numeroConta;
    private Cliente cliente;
    private double saldo;

    public Conta() {
    }

    public Conta(Cliente cliente) throws DadoInvalidoException, DadoNaoInformadoException, NumberFormatException {
        this.setCliente(cliente);
        this.saldo = 0;
        
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

    @Override
    public String toString() {
        return "Conta [cliente=" + cliente + ", numeroConta=" + numeroConta + ", saldo=" + saldo + "]\n";
    } 
}
