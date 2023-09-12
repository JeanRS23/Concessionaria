package br.senai.sp.jandira.Model;

import java.util.Scanner;

public class Cliente {

    /** Declarar Variaveis */
    String nome, email, endereco;

    long telefone, cpf, rg;

    double dinheiroDisponivel;

    /** Scanner */
    Scanner teclado = new Scanner(System.in);

    public void cadastrarCliente(){

        System.out.println("--------- Cadastro Cliente ----------");
        System.out.println("Qual o nome do Cliente: ");
        nome = teclado.nextLine();
        System.out.println("Informe o CPF: ");
        cpf = teclado.nextLong();
        System.out.println("Informe o RG: ");
        rg = teclado.nextLong();
        System.out.println("Informe o Telefone: ");
        telefone = teclado.nextLong();
        teclado.nextLine();
        System.out.println("Informe o email: ");
        email = teclado.nextLine();
        System.out.println("Informe o Endereço: ");
        endereco = teclado.nextLine();
        System.out.println("Informe quanto você tem: [R$] ");
        dinheiroDisponivel = teclado.nextDouble();
        System.out.println("--------- Cadastro Finalizado ---------");
        System.out.println("---------------------------------------");



    }

}
