package br.senai.sp.jandira.Model;

import java.util.Scanner;

public class Menu {

    Scanner teclado = new Scanner(System.in);
    Cliente refListCliente = new Cliente();
    Funcionario refListFuncionario = new Funcionario();
    Veiculo refListVeiculo = new Veiculo();
    Venda objVenda = new Venda();


    public void menu() {

        boolean continuar = true;

        while (continuar) {

            System.out.println("------------------------------");
            System.out.println("----------- Menu -------------");
            System.out.println("1- Cadastrar Cliente");
            System.out.println("2- Cadastrar Veículo");
            System.out.println("3- Cadastrar Funcionario");
            System.out.println("4- Realizar Venda");
            System.out.println("5- Listar Veiculos");
            System.out.println("6- Listar Cliente");
            System.out.println("7- Listar Funcionario");
            System.out.println("8- Pesquisar Veiculos");
            System.out.println("9- Sair");
            System.out.println("------------------------------");

            int escolhaUsuario = teclado.nextInt();
            teclado.nextLine();

            switch (escolhaUsuario) {

                case 1:
                    Cliente objCliente = new Cliente();
                    objCliente.cadastrarCliente();
                    refListCliente.adicionarCliente(objCliente);
                    break;

                case 2:
                    Veiculo objVeiculo = new Veiculo();
                    objVeiculo.cadastrarVeiculo();
                    refListVeiculo.adicionarVeiculo(objVeiculo);
                    break;

                case 3:
                    Funcionario objFuncionario = new Funcionario();
                    objFuncionario.cadastrarFuncionario();
                    refListFuncionario.adicionarFuncionarios(objFuncionario);

                    break;

                case 4:
                    refListCliente.listarClientes();
                    System.out.println("Informe o nome do Cliente: ");
                    String nomeComprador = teclado.nextLine();

                    refListVeiculo.listarVeiculos();
                    System.out.println("Informe o modelo do Veiculo:");
                    String modeloVeiculo = teclado.nextLine();

                    refListFuncionario.listarFuncionario();
                    System.out.println("Informe o nome do Vendedor: ");
                    String nomeVendedor = teclado.nextLine();

                    Cliente objComprador = refListCliente.pesquisarCliente(nomeComprador);

                    Veiculo objVeiculoVenda = refListVeiculo.localizarVeiculoCompra(modeloVeiculo);

                    Funcionario objVendedor = refListFuncionario.pesquisarVendedor(nomeVendedor);

                    boolean formadePagamento = objVenda.avaliarFormaPagamento();

                    boolean validaVenda = false;
                    boolean validaFinanciamento = false;

                    if (formadePagamento){
                        validaVenda = objVenda.realizarVenda(objVeiculoVenda, objComprador);
                    }else {
                        validaFinanciamento = objVenda.realizarFinanciamento(objComprador, objVeiculoVenda);
                    }

                    if (validaVenda || validaFinanciamento){

                        if (validaVenda){
                            objComprador.dinheiroDisponivel -= objVeiculoVenda.preco;
                        } else {
                            objComprador.dinheiroDisponivel -= objVeiculoVenda.preco;
                        }

                        System.out.println("/// ----- Parabéns ----- ///");
                        objComprador.dinheiroDisponivel -= objVeiculoVenda.preco;
                        System.out.println("O saldo do cliente é: " + objComprador.dinheiroDisponivel);

                        objVendedor.receberComissao(objVeiculoVenda);
                        System.out.println("O funcionario recebeu: " + objVendedor.comissao);
                    }


                    break;

                case 5:
                    refListVeiculo.listarVeiculos();
                    break;

                case 6:
                    refListCliente.listarClientes();
                    break;

                case 7:
                    refListFuncionario.listarFuncionario();
                    break;

                case 8:
                    System.out.println("Informe o modelo do Veiculo:");
                    String veiculoPesquisado = teclado.nextLine();
                    boolean validaVeiculo = false;


                    if (veiculoPesquisado != null && veiculoPesquisado != ""){
                        validaVeiculo = refListVeiculo.pesquisarVeiculo(veiculoPesquisado);
                    }


                    if (validaVeiculo) {
                        System.out.println("Veiculo disponivel para compra");
                    } else {
                        System.out.println("Veiculo Indisponivel");
                    }

                    break;

                case 9:
                    continuar = false;
                    break;
            }

            if (escolhaUsuario < 0 || escolhaUsuario > 9) {

                System.out.println("Escolha uma opção válida! ");
            }

        }

    }
}
