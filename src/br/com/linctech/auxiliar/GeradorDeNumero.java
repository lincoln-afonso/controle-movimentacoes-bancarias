package br.com.linctech.auxiliar;

import java.util.Random;

public class GeradorDeNumero {
    public GeradorDeNumero() {};

    public static int gerarNumero(int minimo, int maximo) {
        Random random = new Random();
        int numero;
    
        do {
            numero = random.nextInt(maximo);
        } while (numero < minimo);    
        return numero;
    }
}