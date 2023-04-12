package app;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

import br.com.linctech.auxiliar.ColecaoVaziaException;
import br.com.linctech.auxiliar.DadoInvalidoException;
import br.com.linctech.auxiliar.DadoNaoInformadoException;
import br.com.linctech.auxiliar.FuncaoSistema;
import br.com.linctech.auxiliar.InicializacaoArquivo;
import br.com.linctech.auxiliar.Menu;
import br.com.linctech.auxiliar.Serializador;
import br.com.linctech.auxiliar.TipoOperacao;
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
 * movimentação.
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
        Cliente cliente = new Cliente(setClientes.size() + 1);
        String nome;
        String telefone;
        boolean eValido;

        System.out.println("Número do cliente: " + cliente.getNumeroCliente());
        this.getLeia().nextLine();

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

    public Cliente pesquisarCliente(Set<Cliente> setClientes, int numeroCliente) {
        Cliente cli;
        Iterator<Cliente> c = setClientes.iterator();
        while (c.hasNext()) {
            cli = c.next();
            if (cli.getNumeroCliente() == numeroCliente) {
                return cli;
            }
        }
        return null;
    }

    public Cliente pesquisarCliente(Set<Cliente> setClientes, Cliente cliente) {
        Cliente cli;
        Iterator<Cliente> c = setClientes.iterator();
        while (c.hasNext()) {
            cli = c.next();
            if (cli.getNumeroCliente() == cliente.getNumeroCliente()) {
                return cli;
            }
        }
        return null;
    }

    public Conta pesquisarConta(Set<Conta> setContas, int numeroConta) {
        Conta co;
        Iterator<Conta> c = setContas.iterator();
        while (c.hasNext()) {
            co = c.next();
            if (co.getNumeroConta() == numeroConta)
                return co;
        }
        return null;
    }

    @Override
    public boolean realizarSaque(Set<Conta> setContas, List<HistoricoMovimentacao> listHistoricoMovimentacao)
            throws ColecaoVaziaException {
        String valor;
        String numeroConta;
        int numero;
        Conta conta = new Conta();
        HistoricoMovimentacao hm;

        if (setContas.size() == 0)
            throw new ColecaoVaziaException("Não há contas registradas no sistema!");

        this.getLeia().nextLine();
        System.out.print("Forneça o número da conta: ");
        numeroConta = this.getLeia().nextLine();

        try {
            if (numeroConta.isEmpty())
                throw new DadoNaoInformadoException("Número da conta não foi informado!");

            numero = Integer.parseInt(numeroConta);
            conta = this.pesquisarConta(setContas, numero);
            if (conta == null)
                System.out.println("Conta não encontrada!");
            else {
                System.out.print("Valor: ");
                valor = this.getLeia().nextLine();

                try {
                    conta.sacar(valor);
                    hm = new HistoricoMovimentacao(conta, valor, "DEBITO");
                    return listHistoricoMovimentacao.add(hm);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (DadoInvalidoException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (DadoNaoInformadoException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean realizarDeposito(Set<Conta> setContas, List<HistoricoMovimentacao> listHistoricoMovimentacao)
            throws ColecaoVaziaException {
        String valorDeposito;
        String numeroConta;
        int numero;
        Conta conta = new Conta();
        HistoricoMovimentacao hm;

        if (setContas.size() == 0)
            throw new ColecaoVaziaException("Não há contas registradas no sistema!");

        this.getLeia().nextLine();
        System.out.print("Forneça o número da conta: ");
        numeroConta = this.getLeia().nextLine();

        try {
            numero = Integer.parseInt(numeroConta);

            conta = this.pesquisarConta(setContas, numero);
            if (conta == null)
                System.out.println("Conta não encontrada!");
            else {
                System.out.print("Valor: ");
                valorDeposito = this.getLeia().nextLine();

                try {
                    conta.depositar(valorDeposito);
                    hm = new HistoricoMovimentacao(conta, valorDeposito, "CREDITO");
                    return listHistoricoMovimentacao.add(hm);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (DadoInvalidoException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (DadoNaoInformadoException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void listarMovimentacoes(List<HistoricoMovimentacao> listHistoricoMovimentacao, Conta conta) {
        HistoricoMovimentacao hm;

        Iterator<HistoricoMovimentacao> h = listHistoricoMovimentacao.iterator();
        if (listHistoricoMovimentacao.size() > 0)
            System.out.println("Data \t\tValor \tTipo Operação");
        while (h.hasNext()) {
            hm = h.next();
            if (hm.getConta().equals(conta))
                System.out.println(hm.getDataMovimentacao() + "\t" + hm.getValor() + "\t" + hm.getOperacao());
        }
        System.out.println();
    }

    @Override
    public void listarContas(Set<Conta> setContas, List<HistoricoMovimentacao> listHistoricoMovimentacao)
            throws ColecaoVaziaException {
        Conta conta;

        if (setContas.size() == 0)
            throw new ColecaoVaziaException("Não há contas cadastradas!");

        Iterator<Conta> c = setContas.iterator();
        while (c.hasNext()) {
            conta = c.next();
            System.out.println("Nº conta: " + conta.getNumeroConta());
            System.out.println("Saldo  \tProprietario");
            System.out.println(conta.getSaldo() + "\t" + conta.getCliente().getNome());
            this.listarMovimentacoes(listHistoricoMovimentacao, conta);
        }

    }

    @Override
    public void excluirMovimentacao(List<HistoricoMovimentacao> listHistoricoMovimentacao, Conta conta) {
        HistoricoMovimentacao hm;

        Iterator<HistoricoMovimentacao> h = listHistoricoMovimentacao.iterator();
        while (h.hasNext()) {
            hm = h.next();
            if (hm.getConta().equals(conta))
                listHistoricoMovimentacao.remove(hm);
        }
    }

    @Override
    public boolean excluirConta(Set<Conta> setContas, List<HistoricoMovimentacao> listHistoricoMovimentacao)
            throws ColecaoVaziaException {
        String numeroConta;
        int numero;
        Conta conta;

        if (setContas.size() == 0)
            throw new ColecaoVaziaException("Não há contas cadastradas!");

        this.getLeia().nextLine();
        System.out.print("Número da conta: ");
        numeroConta = this.getLeia().nextLine();

        try {
            if (numeroConta.isEmpty())
                throw new DadoNaoInformadoException("Número da conta não foi informado!");

            numero = Integer.parseInt(numeroConta);
            conta = this.pesquisarConta(setContas, numero);
            if (conta != null) {
                this.excluirMovimentacao(listHistoricoMovimentacao, conta);
                return setContas.remove(conta);
            } else
                System.out.println("Conta não encontrada!");
        } catch (DadoNaoInformadoException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean cadastrarConta(Set<Conta> setContas, Set<Cliente> setClientes) {
        Conta conta = new Conta(setContas.size() + 1);
        String numeroCliente;
        Cliente cliente;
        boolean eValido;
        int numero;

        System.out.println("Número da conta: " + conta.getNumeroConta());
        this.getLeia().nextLine();

        do {
            eValido = false;
            System.out.print("Informe o número do cliente dono da conta sendo aberta: ");
            numeroCliente = this.getLeia().nextLine();
            try {
                if (numeroCliente.isEmpty())
                    throw new DadoNaoInformadoException("Número do cliente não foi informado!");

                numero = Integer.parseInt(numeroCliente);
                if (numero <= 0)
                    throw new DadoInvalidoException("Número de cliente inválido!");

                cliente = this.pesquisarCliente(setClientes, numero);
                if (cliente != null) {
                    conta.setCliente(cliente);
                } else {
                    System.out.println("O número informado não corresponde a nenhum cliente!");
                    return false;
                }

                eValido = true;
            } catch (DadoNaoInformadoException e) {
                System.out.println(e.getMessage());
            } catch (DadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);
        return setContas.add(conta);
    }

    public static void main(String[] args) throws Exception {
        InicializacaoArquivo ia = new InicializacaoArquivo("arquivo_clientes.dat", "arquivo_contas.dat",
                "arquivo_histiricoMovimentacoes.dat");
        App app = new App();
        String opcao = "";
        Set<Cliente> setClientes;
        Set<Conta> setContas;
        List<HistoricoMovimentacao> listHistoricoMovimentacao;

        do {
            setClientes = (Set<Cliente>) Serializador.recuperar(ia.getFileCliente().getName());
            setContas = (Set<Conta>) Serializador.recuperar(ia.getFileConta().getName());
            listHistoricoMovimentacao = (List<HistoricoMovimentacao>) Serializador
                    .recuperar(ia.getFileHistoricoMovimentacao().getName());

            Menu.perguntarOpcaoDesejada();
            opcao = app.getLeia().next();

            switch (opcao) {

            case "1":
                if (app.cadastrarConta(setContas, setClientes)) {
                    Serializador.gravar(setContas, ia.getFileConta().getName());
                    System.out.println("Conta aberta!\n");
                } else
                    System.out.println("Não foi possível abrir conta!");
                break;

            case "2":
                if (app.cadastrarCliente(setClientes)) {
                    Serializador.gravar(setClientes, ia.getFileCliente().getName());
                    System.out.println("Cliente cadastrado!\n");
                } else
                    System.out.println("O cliente informado já se encontra cadastrado!\n");
                break;

            case "3":
                try {
                    if (app.realizarSaque(setContas, listHistoricoMovimentacao)) {
                        System.out.println("Saque efetuado!\n");
                        Serializador.gravar(setContas, ia.getFileConta().getName());
                        Serializador.gravar(listHistoricoMovimentacao, ia.getFileHistoricoMovimentacao().getName());
                    } else
                        System.out.println("Saque não realizado!\n");
                } catch (ColecaoVaziaException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "4":
                try {
                    if (app.realizarDeposito(setContas, listHistoricoMovimentacao)) {
                        System.out.println("Depósito realizado!");
                        Serializador.gravar(setContas, ia.getFileConta().getName());
                        Serializador.gravar(listHistoricoMovimentacao, ia.getFileHistoricoMovimentacao().getName());
                    } else
                        System.out.println("Depósito não realizado!");
                } catch (ColecaoVaziaException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "5":
                try {
                    app.listarContas(setContas, listHistoricoMovimentacao);
                } catch (ColecaoVaziaException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "6":
                try {
                    if (app.excluirConta(setContas, listHistoricoMovimentacao)) {
                        System.out.println("Conta excluída!\n");
                        Serializador.gravar(listHistoricoMovimentacao, ia.getFileHistoricoMovimentacao().getName());
                        Serializador.gravar(setContas, ia.getFileConta().getName());
                    }

                } catch (ColecaoVaziaException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "7":
                System.out.println("Programa Encerrado!\n");
                break;

            default:
                System.out.println("Opção inválida!\n");
                break;
            }
        } while (!opcao.equals("7"));
        System.out.println(setContas);
        app.getLeia().close();
    }
}