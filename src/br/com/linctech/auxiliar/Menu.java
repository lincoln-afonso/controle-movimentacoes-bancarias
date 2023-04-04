package br.com.linctech.auxiliar;

public abstract class Menu {
    private static void exibirOpcoes() {
        System.out.println("\nMENU");
        System.out.println("1 - Cadastrar Conta");
        System.out.println("2 - Cadastrar Cliente");
        System.out.println("3 - Sacar");
        System.out.println("4 - Depositar");
        System.out.println("5 - Listar Contas e Suas Movimentações");
        System.out.println("6 - Excluir Conta");
        System.out.println("7 - Encerrar\n");
    }

    public static void perguntarOpcaoDesejada() {
        Menu.exibirOpcoes();
        System.out.print("Informe o número que corresponde a opção desejada: ");
    }
}