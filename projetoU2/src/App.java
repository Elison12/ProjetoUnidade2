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
        Banco caixa = new Banco("caixa economica", "3");

        //cria agencia, dizendo  nome , codigo e banco pertencente
        Agencia pontobanese = new Agencia("pontobanese", "11.2", banese);
        Agencia pontobanese2 = new Agencia("pontobanese2","12.2", banese);

        Agencia caixa24h = new Agencia("caixa24h", "33.1", caixa);

        //cria cliente, dizendo um nome e cpf.
        Cliente elison = new Cliente("Elison", "835.345.23");
        //cria cliente, dizendo um nome e cpf..
        Cliente igor = new Cliente("igor", "453.34.232");
        Cliente ruesley = new Cliente("ruesley", "020.225.011-18");
        Cliente gabriel = new Cliente("gabriel", "029.11.234-00");

        // adiciona conta
        elison.addConta("conta corrente","elison", 1000f, "elison@kalil.com", "01.1", pontobanese);
        gabriel.addConta("conta corrente","gabriel", 1200f, "gabriel@gmail.com", "01.2", pontobanese);
        igor.addConta("conta poupanca","igor", 1200f, "igor@gmail.com", "01.3", pontobanese);
        ruesley.addConta("outra conta","ruesley", 1300f, "ruesley@xinaider.com", "01.4", pontobanese);

        elison.fazerDeposito(400f, igor, pontobanese, "01.3");

        ruesley.fazerSaque(30f, "ruesley", pontobanese, "01.4");

        elison.fazerTransferencia(450.f, "2", pontobanese, "01.1", gabriel, "01.2", "2", pontobanese);

        elison.gerarChavePix(pontobanese, "01.1");

        
        System.out.println("END");


        Cliente patty = new Cliente("patty", "346.235");
        patty.addConta("conta poupança", "patty", 350f, "@patty", "01.6", pontobanese);
    }
}
