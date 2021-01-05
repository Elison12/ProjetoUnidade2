
/*
    - Gerencia de tudo é aqui
*/
import bancospacote.tiposdecontas.Cliente;


import frontEnd.*;



public class App {
    public static void main(String[] args) {

        //cria cliente, dizendo um nome e cpf..
        Cliente elison = new Cliente("Elison", "835.345.23");
        //cria cliente, dizendo um nome e cpf..
        Cliente igor = new Cliente("igor", "453.34.232");

        // adicionando uma conta a ele. Essa função está em "Cliente"
        elison.addConta("conta corrente");
        elison.addConta("conta poupanca");
        igor.addConta("conta salario");

        //depositando em um objeto cliente. Assim o atributo saldo que está em conta e herdado para contaPoupança está preenchido
        // elison.depositar(500);

        //transferir de elison para igor uma valor de 300. Essa função está em "Cliente"
        // elison.transferencia(igor, 300);


        // elison.cadastrarPix(elison);
        // igor.cadastrarPix(igor);

        new Janela();
                
        System.out.println("END");


    }



}
