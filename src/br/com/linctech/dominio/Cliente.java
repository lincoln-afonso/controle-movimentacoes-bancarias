package br.com.linctech.dominio;

import java.io.Serializable;

import br.com.linctech.auxiliar.DadoInvalidoException;
import br.com.linctech.auxiliar.DadoNaoInformadoException;

/**
 * <h1>Cliente</h1>
 * Especifica os dados e os comportamentos de um cliente.
 * @author AFONSO, Lincoln
 * @since Abril/2023
 * @version v 1.0
 */
public class Cliente implements Serializable, Comparable<Cliente> {
    private static final long serialVersionUID = 1L;
    private int numeroCliente;
    private String nome;
    private String telefone;
    private Endereco endereco;
    
    /**
     * <h2>Construtor</h2>
     */
    public Cliente() {
    }

    /** 
     * <h2>Construtor</h2>
     * @param String numeroCliente,
     * @param String nome
     * @param String telefone 
     * @param Endereco endereco
     * @throws DaDadoNaoInformadoException
     * @throws DadoInvalidoException
     */
    public Cliente(String numeroCliente, String nome, String telefone, Endereco endereco)
            throws DadoNaoInformadoException, DadoInvalidoException {
        this.setEndereco(endereco);
        this.setNome(nome);
        this.setNumeroCliente(numeroCliente);
        this.setTelefone(telefone);
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) throws DadoNaoInformadoException, DadoInvalidoException {
        int numero;

        if (numeroCliente.isEmpty()) 
            throw new DadoNaoInformadoException("Número do cliente não informado!");
        
        numero = Integer.parseInt(numeroCliente);
        if (numero <= 0)
            throw new DadoInvalidoException("Número do cliente é inválido!");
        this.numeroCliente = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws DadoNaoInformadoException {
        if (nome.isEmpty()) 
            throw new DadoNaoInformadoException("Nome não informado!");
        this.nome = nome.toUpperCase();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws DadoNaoInformadoException  {
        if (telefone.isEmpty())
            throw new DadoNaoInformadoException("Nome não informado!");
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numeroCliente;
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
        Cliente other = (Cliente) obj;
        if (numeroCliente != other.numeroCliente)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [endereco=" + endereco + ", nome=" + nome + ", numeroCliente=" + numeroCliente + ", telefone="
                + telefone + "]\n";
    }

    @Override
    public int compareTo(Cliente cliente) {
        return this.getNome().compareToIgnoreCase(cliente.getNome());
    }



    

    
























































































    



















}