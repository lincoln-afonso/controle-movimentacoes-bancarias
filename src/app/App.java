package app;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import br.com.linctech.auxiliar.DadoInvalidoException;
import br.com.linctech.auxiliar.DadoNaoInformadoException;
import br.com.linctech.auxiliar.FuncaoSistema;
import br.com.linctech.auxiliar.InicializacaoArquivo;
import br.com.linctech.auxiliar.Menu;
import br.com.linctech.auxiliar.Serializador;
import br.com.linctech.dominio.Cliente;
import br.com.linctech.dominio.Conta;
import br.com.linctech.dominio.Endereco;
import br.com.linctech.dominio.HistoricoMovimentacao;

/*
 * Observe as informações a seguir:
 * CLIENTE CONTA MOVIMENTAÇÃO
 * Número do cliente
 * Nome
 * Telefone
 * Endereço

 * CONTA
 * Número da conta
 * cliente
 * Saldo
 * Numero Conta

 * MOVIMENTAÇÃO
 * Conta
 * Data da movimentação
 * Operação
 * Valor

 * Crie um programa que faça o cadastramento de contas, verificando se o número do cliente titular dessa
 * conta já foi previamente cadastrado em Clientes. Se existir, permitir a inclusão. Caso contrário, mostrar
 * a mensagem Cliente não cadastrado e abrir uma tela que permita o cadastramento desse cliente. Permitir
 * que o cliente efetue uma operação (D- débito ou C- crédito) e atualize,se possível, a estrutura de
 * movimentação. Mostre ao final, todas as contas cadastradas com suas respectivas movimentações.
 */

public class App implements FuncaoSistema {
    private static Scanner leia = new Scanner(System.in);

    public Scanner getLeia() {
        return leia;
    }

    private void cadastrarEndereco(Cliente cliente) {
        Endereco endereco = new Endereco();
        String numeroCasa;
        String rua;
        String bairro;
        String cidade;
        String uf;
        boolean eValido;

        do {
            eValido = false;
            System.out.print("Número da casa: ");
            numeroCasa = this.getLeia().nextLine();

            try {
                endereco.setNumeroCasa(numeroCasa);
                eValido = true;
            } catch (DadoNaoInformadoException e) {
                System.out.println(e.getMessage());
            } catch (DadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            System.out.print("Rua: ");
            rua = this.getLeia().nextLine();

            try {
                endereco.setRua(rua);
                eValido = true;
            } catch (DadoNaoInformadoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            System.out.print("Bairro: ");
            bairro = this.getLeia().nextLine();

            try {
                endereco.setBairro(bairro);
                eValido = true;
            } catch (DadoNaoInformadoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            System.out.print("Cidade: ");
            cidade = this.getLeia().nextLine();

            try {
                endereco.setCidade(cidade);
                eValido = true;
            } catch (DadoNaoInformadoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            System.out.print("UF (informe a sigla do Estado em que mora): ");
            uf = this.getLeia().nextLine();

            try {
                endereco.setUnidadeFederal(uf);
                eValido = true;
            } catch (Exception e) {
                System.out.println("Unidade Federal Inválida!");
            }
        } while (eValido == false);

        cliente.setEndereco(endereco);
    }

    @Override
    public boolean cadastrarCliente(Set<Cliente> setClientes) {
        Cliente cliente = new Cliente();
        String numeroCliente;
        String nome;
        String telefone;
        boolean eValido;

        this.getLeia().nextLine();
        do {
            eValido = false;
            System.out.print("Número do cliente: ");
            numeroCliente = this.getLeia().nextLine();

            try {
                cliente.setNumeroCliente(numeroCliente);
                eValido = true;
            } catch (DadoNaoInformadoException e) {
                System.out.println(e.getMessage());
            } catch (DadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            System.out.print("Nome: ");
            nome = this.getLeia().nextLine();

            try {
                cliente.setNome(nome);
                eValido = true;
            } catch (DadoNaoInformadoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            System.out.print("Telefone: ");
            telefone = this.getLeia().nextLine();

            try {
                cliente.setTelefone(telefone);
                eValido = true;
            } catch (DadoNaoInformadoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        this.cadastrarEndereco(cliente);
        return setClientes.add(cliente);
    }

    @Override
    public boolean cadastrarConta(Set<Conta> setContas, Set<Cliente> setClientes) {
        Conta conta = new Conta();
        Cliente cliente;

        return false;
    }

    @Override
    public boolean sacar(Conta conta, Set<HistoricoMovimentacao> historicoMovimentacao) {
        return false;
    }

    @Override
    public boolean depositar(Conta conta, Set<HistoricoMovimentacao> historicoMovimentacao) {
        return false;
    }

    @Override
    public void listarContas(Set<Conta> setContas, Set<HistoricoMovimentacao> historicoMovimentacao) {

    }

    @Override
    public boolean excluirConta(Set<Conta> setContas, Set<HistoricoMovimentacao> historicoMovimentacao) {
        return false;
    }

    
    public static void main(String[] args) throws Exception {
        InicializacaoArquivo ia = new InicializacaoArquivo("arquivo_clientes.dat", "arquivo_contas.dat", "arquivo_histiricoMovimentacoes.dat");
        App app = new App();
        String opcao = "";
        Set<Cliente> setClientes;
        Set<Conta> setContas;
        Set<HistoricoMovimentacao> setHistoricoMovimentacoes;

        do {
            setClientes = (Set<Cliente>) Serializador.recuperar(ia.getFileCliente().getName());
            Menu.perguntarOpcaoDesejada();
            opcao = app.getLeia().next();

            switch (opcao) {
                case "1":

                    break;
                
                case "2":
                    if (app.cadastrarCliente(setClientes)) {
                        Serializador.gravar(setClientes, ia.getFileCliente().getName());
                        System.out.println("Cliente cadastrado!\n");
                    }
                    else 
                        System.out.println("O cliente informado já se encontra cadastrado!\n");
                    break;

                case "3":

                    break;

                case "4":

                    break;

                case "7":
                    System.out.println("Programa Encerrado!\n");
                    break;

                default:
                    System.out.println("Opção inválida!\n");
                    break;
            }
        } while (!opcao.equals("7"));
        app.getLeia().close();
        System.out.println(setClientes);
    }
}