package br.senai.sp.jandira.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionario {

    /** Declarar Variaveis */
    String nome, email, endereco;

    long telefone, cpf, rg;

    double comissao;

    /** Scanner */
    Scanner teclado = new Scanner(System.in);
    List<Funcionario> listFuncionario = new ArrayList<>();

    public void cadastrarFuncionario(){

        System.out.println("--------- Cadastro Funcionario ----------");
        System.out.println("Qual o nome do Funcionario: ");
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
        System.out.println("--------- Cadastro Finalizado ---------");
        System.out.println("---------------------------------------");



    }

    public void receberComissao(Veiculo objVeiculo){

        comissao += objVeiculo.preco * 0.10;
        System.out.println("A comissão foi de " + comissao);

    }

    public void adicionarFuncionarios(Funcionario objFuncionario) {
        listFuncionario.add(objFuncionario);
    }

    public void listarFuncionario(){
        for(Funcionario objFuncionario : listFuncionario){
            System.out.println(objFuncionario.nome);
        }

    }
    public Funcionario pesquisarVendedor(String nome){
        for (Funcionario vendedor : listFuncionario){
            if (vendedor.nome.equalsIgnoreCase(nome)){
                return vendedor;
            }
        }
        return null;

    }

}
