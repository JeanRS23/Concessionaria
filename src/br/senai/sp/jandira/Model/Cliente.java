package br.senai.sp.jandira.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    /** Declarar Variaveis */
    String nome, email, endereco;

    long telefone, cpf, rg;

    double dinheiroDisponivel;

    /** Scanner */
    Scanner teclado = new Scanner(System.in);

    List<Cliente> listClientes = new ArrayList();

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
        teclado.nextLine();
        System.out.println("--------- Cadastro Finalizado ---------");
        System.out.println("---------------------------------------");

    }

    public void adicionarCliente(Cliente objCLiente){
        listClientes.add(objCLiente);

    }

    public void listarClientes(){
        for (Cliente objCliente : listClientes){
            System.out.println(objCliente.nome);
        }

    }

    public Cliente pesquisarCliente (String nome){

        for (Cliente cliente : listClientes){
            if (cliente.nome.equalsIgnoreCase(nome)){
                return cliente;
            }

        }
        return null;

    }

}
