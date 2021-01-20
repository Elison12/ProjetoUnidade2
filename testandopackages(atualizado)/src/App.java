
/*
    - Gerencia de tudo é aqui
*/
import bancospacote.Banco;
import bancospacote.tiposdecontas.Agencia;
import bancospacote.tiposdecontas.Cliente;

public class App {
    public static void main(String[] args) {
        //cria banco, dizendo nome codigo
        Banco banese = new Banco("banese","2");
        
        //cria agencia, dizendo  nome , codigo e banco pertencente
        Agencia pontobanese = new Agencia("pontobanese", "11.2", banese);
        Agencia pontobanese2 = new Agencia("pontobanese2","12.2", banese);
        
        
        System.out.println("Nome da agência :");
        System.out.println(pontobanese.nome);
        
        System.out.println("Nome do banco que a agência pertence:");
        System.out.println(pontobanese.banco.nome);
        
        System.out.println("O banco banese possui essas agencias:");
        // Passa um for no array list, pega o objeto e imprime o nome
         for(int i=0; i<banese.agencias.size(); i++){
            System.out.println(banese.agencias.get(i).nome);
        }
         
        //cria cliente, dizendo um nome e cpf.
        Cliente elison = new Cliente("Elison", "835.345.23");
        
        System.out.println("CPF do cliente elison:");
        System.out.println(elison.cpf);
        
        
        //cria cliente, dizendo um nome e cpf..
        Cliente igor = new Cliente("igor", "453.34.232");
        Cliente ruesley = new Cliente("ruesley", "020.225.011-18");
        Cliente gabriel = new Cliente("gabriel", "029.11.234-00");
        
        // adiciona conta 
        
        elison.addConta("conta corrente","elison",1000f, "elison@kalil.com", "01.1", pontobanese);
        gabriel.addConta("conta corrente","gabriel",1200f, "gabriel@gmail.com", "01.2", pontobanese);
        igor.addConta("conta poupanca","igor",1200f, "igor@gmail.com", "01.3", pontobanese);
        ruesley.addConta("outra conta","ruesley", 1300f, "ruesley@xinaider.com", "01.4", pontobanese);
        elison.addConta("conta corrente","elison", 1500f, "7991045564", "02.1", pontobanese2);
        elison.addConta("conta corrente","elison", 200f, "7991045564", "02.1", pontobanese2);
        
        
        
      
        
        System.out.println("A agencia pontobanese tem essas contas:");
        for(int i=0; i<pontobanese.contas.size(); i++){
            System.out.println(pontobanese.contas.get(i).codigo);
        }
        
        System.out.println("A agencia pontobanese2 tem essas contas:");
         for(int i=0; i<pontobanese2.contas.size(); i++){
            System.out.println(pontobanese2.contas.get(i).codigo);
        }
         
        // adicionando uma conta a ele. Essa função está em "Cliente"
       // elison.addConta("conta corrente", 50f, "elisson@gmail.com", "0001");
       // elison.addConta("conta poupanca", 100f, "elisson2@gmail.com", "0002");
       // igor.addConta("conta salario", 50f, "igorjoaz@gmail.com", "0031");
       // System.out.println(igor.contas[2].saldo);

        //depositando em um objeto cliente. Assim o atributo saldo que está em conta e herdado para contaPoupança está preenchido
        // elison.depositar(500);

        //transferir de elison para igor uma valor de 300. Essa função está em "Cliente"
        // elison.transferencia(igor, 300);


        // elison.cadastrarPix(elison);
        // igor.cadastrarPix(igor);
                
        System.out.println("END");


    }



}
