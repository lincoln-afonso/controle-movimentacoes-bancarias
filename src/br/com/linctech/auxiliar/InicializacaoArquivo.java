package br.com.linctech.auxiliar;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import br.com.linctech.dominio.Cliente;
import br.com.linctech.dominio.Conta;
import br.com.linctech.dominio.HistoricoMovimentacao;

public class InicializacaoArquivo {
    private File fileCliente;
    private File fileConta;
    private File fileHistoricoMovimentacao;

    public InicializacaoArquivo(String nomeCaminhoA, String nomeCaminhoB, String nomeCaminhoC) {
        this.fileCliente = new File(nomeCaminhoA);
        this.fileConta = new File(nomeCaminhoB);
        this.fileHistoricoMovimentacao = new File(nomeCaminhoB);

        if (!this.fileCliente.exists()) {
            try {
                Set<Cliente> setClientes = new TreeSet<>();
                this.fileCliente.createNewFile();
                Serializador.gravar(setClientes, nomeCaminhoA);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if (!this.fileConta.exists()) {
            try {
                Set<Conta> setContas = new TreeSet<>();
                this.fileConta.createNewFile();
                Serializador.gravar(setContas, nomeCaminhoB);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if (!this.fileHistoricoMovimentacao.exists()) {
            try {
                Set<HistoricoMovimentacao> setHistoricoMovimentacoes = new TreeSet<>();
                this.fileHistoricoMovimentacao.createNewFile();
                Serializador.gravar(setHistoricoMovimentacoes, nomeCaminhoC);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public File getFileCliente() {
        return fileCliente;
    }

    public File getFileConta() {
        return fileConta;
    }

    public File getFileHistoricoMovimentacao() {
        return fileHistoricoMovimentacao;
    }
}