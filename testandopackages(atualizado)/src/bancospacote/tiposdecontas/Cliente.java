/*

- Essa é a camada final da estrutura, ta marcada como final, assim não podemos criar mais filhas a partir daqui

- Nela setamos os atributos dos clientes

- Quando criamos um objeto desse tipo temos tbm o atributo pix que tá laaa na classe "BancoCentral", se pá ta errado
  mas coloquei pra fazer teste

- tem um atributo que é Conta, e veja q ele não ta no construtor, assim não aprecisamos dizer qual a conta
 do cliente no momento em que criamos el, só dps
 
- Tem aquele de um cliente pode ter mais de uma conta, possivelmente isso se tornará uma array de conta
*/
package bancospacote.tiposdecontas;


// import bancospacote.*;

public final class Cliente extends Agencia {
    
    public String nome;
    public String cpf;
    public Conta conta;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void addConta(String nomeconta) {
        if (nomeconta == "conta corrente") {
            this.conta = new ContaCorrente();
            
        } else if (nomeconta == "conta poupanca") {
            this.conta = new ContaPoupanca();
        } else {
            this.conta = new ContaSalario();
        }
    }

    public void depositar(float valordeposito) {
        conta.saldo += valordeposito;
        System.out.println("deposito efetuado com sucesso!");
    }

    public void transferencia(Cliente clientedestino, float valortransferencia) {

        clientedestino.conta.setSaldo(valortransferencia + clientedestino.conta.saldo);
        conta.setSaldo(conta.saldo - valortransferencia);
        
        System.out.println("saldo atual destino: "+ clientedestino.conta.getSaldo());
        System.out.println("meu saldo atual: " + conta.getSaldo());
    }

    public void cadastrarPix(Cliente inCliente) {
        System.out.println("Olá, para cadastar sua chavePix escolha as opções\n");
        System.out.println("1 para cpf\n" +
            "2 para email\n" +
            "3 para telefone\n" +
            "4 para gerar chave aleatoria"
        );

        if (inCliente.conta instanceof ContaCorrente) {
            ((inCliente.conta).pix) = "assombrado";
        } else if(inCliente.conta instanceof ContaPoupanca) {
            ((inCliente.conta).pix) = "açucar";
        } else {
            ((inCliente.conta).pix) = "biscoito";
        }
    }
}
