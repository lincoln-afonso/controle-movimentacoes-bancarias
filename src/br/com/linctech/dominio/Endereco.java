package br.com.linctech.dominio;

import java.io.Serializable;

import br.com.linctech.auxiliar.DadoInvalidoException;
import br.com.linctech.auxiliar.DadoNaoInformadoException;
import br.com.linctech.auxiliar.UnidadeFederal;

/**
 * <h1>Endereco</h1>
 * Especifica os dados e os comportamentos apresentados por um endereço.
 * @author AFONSO, Lincoln
 * @since Abril/2023
 * @version v 1.0
 */
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    private int numeroCasa;
    private String rua;
    private String bairro;
    private String cidade;
    private UnidadeFederal unidadeFederal;

    /**
     *<h2>Construtor</h2>
     */
    public Endereco() {
    }
    
    /**
     *<h2>Construtor</h2>
     @param String numeroCasa
     @param String rua
     @param String bairro
     @param String cidade
     @param String unidadeFederal
     @throws DadoNaoInformadoException
     @throws DadoInvalidoException
     */
    public Endereco(String numeroCasa, String rua, String bairro, String cidade, String unidadeFederal) throws DadoNaoInformadoException, DadoInvalidoException {
        this.setNumeroCasa(numeroCasa);
        this.setRua(rua);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setUnidadeFederal(unidadeFederal);
	}

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) throws DadoNaoInformadoException, DadoInvalidoException {
        int numero;

        if (numeroCasa.isEmpty()) 
            throw new DadoNaoInformadoException("Número da casa não informado!");

        numero = Integer.parseInt(numeroCasa);
        if (numero <= 0)
            throw new DadoInvalidoException();
        this.numeroCasa = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) throws DadoNaoInformadoException {
        if (rua.isEmpty())
            throw new DadoNaoInformadoException("Rua não informada!");
        this.rua = rua.toUpperCase();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws DadoNaoInformadoException {
        if (bairro.isEmpty())
            throw new DadoNaoInformadoException("Bairro não informado!");
        this.bairro = bairro.toUpperCase();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws DadoNaoInformadoException {
        if (bairro.isEmpty())
            throw new DadoNaoInformadoException("Cidade não informada!");
        this.cidade = cidade.toUpperCase();
    }

    public UnidadeFederal getUnidadeFederal() {
        return unidadeFederal;
    }

    public void setUnidadeFederal(String unidadeFederal) {
        this.unidadeFederal = UnidadeFederal.valueOf(unidadeFederal);
    }

    @Override
    public String toString() {
        return "Endereco [bairro=" + bairro + ", cidade=" + cidade + ", numeroCasa=" + numeroCasa + ", rua=" + rua
                + ", unidadeFederal=" + unidadeFederal + "]\n";
    }
}