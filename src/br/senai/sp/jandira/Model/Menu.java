package br.senai.sp.jandira.Model;

import java.util.Scanner;

public class Menu {

    Scanner teclado = new Scanner(System.in);
    Cliente objCliente = new Cliente();
    Funcionario objFuncionario = new Funcionario();
    Venda objVenda = new Venda();
    Veiculo objVeiculo = new Veiculo();

    public void menu(){

        boolean continuar = true;

        while(continuar){

            System.out.println("------------------------------");
            System.out.println("----------- Menu -------------");
            System.out.println("1- Cadastrar Cliente");
            System.out.println("2- Cadastrar Veículo");
            System.out.println("3- Cadastrar Funcionario");
            System.out.println("4- Realizar Venda");
            System.out.println("5- Sair");
            System.out.println("------------------------------");

            int escolhaUsuario = teclado.nextInt();

            switch (escolhaUsuario){

                case 1:
                    objCliente.cadastrarCliente();
                    break;

                case 2:
                    objVeiculo.cadastrarVeiculo();
                    break;

                case 3:
                    objFuncionario.cadastrarFuncionario();
                    break;

                case 4:
                    boolean validaVenda = objVenda.realizarVenda(objVeiculo, objCliente);

                    if (validaVenda){
                        objCliente.dinheiroDisponivel -= objVeiculo.preco;
                        System.out.println("O saldo do cliente é: " + objCliente.dinheiroDisponivel);
                    }

                    break;

                case 5:
                    continuar = false;
                    break;
            }

            if (escolhaUsuario < 0 || escolhaUsuario > 5){

                System.out.println("Escolha uma opção válida! ");
            }

        }

    }
}
