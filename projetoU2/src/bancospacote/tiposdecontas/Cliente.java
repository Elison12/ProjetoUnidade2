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

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import bancoCentral.PIX;


public final class Cliente {
    
    public String nome;
    public String cpf;
    public ArrayList<Conta> minhasContas;
    private Date data = new Date();
   
   public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;  
        minhasContas = new ArrayList<>(); 
    }
  
   public void addConta(String tipo,String cliente,float saldo, String email, String codigo, Agencia agencia){
        boolean temConta = checarConta(cliente, agencia, codigo);
        if(!temConta){
            this.addContaComplemento(tipo, cliente, saldo, email, codigo, agencia);
            System.out.println("Conta criada com sucesso");
        } else{   
            System.out.println("Você ja tem uma conta");
        }
   }
   
   private boolean checarConta(String cliente, Agencia agencia, String numeroConta){
        boolean temConta = false;
        for(int i=0; i<agencia.contas.size(); i++){
            String cliente_conta = agencia.contas.get(i).cliente;
            if (cliente_conta.equals(cliente)) {
                temConta = true;
            }
        }
        return(temConta);
    }

    // varre as lista de contas da agencia buscando pelo numero da conta similar e retorna ele
    private Conta retornaConta(String numeroConta, Agencia essaAgencia) {

        for (int i = 0; i < essaAgencia.contas.size(); i++) {
            String atual = essaAgencia.contas.get(i).codigo;
            if (numeroConta == atual) {
                return essaAgencia.contas.get(i);
            }
        }
        return null;
    }
               
   private void addContaComplemento(String tipo, String cliente, float saldo,
                String pix, String codigo, Agencia agencia) {
        if ("conta corrente".equals(tipo)) {
            minhasContas.add(new ContaCorrente(cliente, saldo, pix, codigo, agencia));
            agencia.contas.add(new ContaCorrente(cliente, saldo, pix, codigo, agencia));
        } else if ("conta poupanca".equals(tipo)) {
            minhasContas.add(new ContaPoupanca(cliente, saldo, pix, codigo, agencia));
            agencia.contas.add(new ContaPoupanca(cliente, saldo, pix, codigo, agencia));
        } else {
            minhasContas.add(new ContaSalario(cliente, saldo, pix, codigo, agencia));
            agencia.contas.add(new ContaSalario(cliente, saldo, pix, codigo, agencia));
        }
    }

    // metados de tranferencia e saque
    public void fazerDeposito(float valor, Cliente clienteTitular, Agencia agenciaDestino, String numeroConta) {
        Conta verificarExistencia = retornaConta(numeroConta, agenciaDestino);
        if (verificarExistencia != null) {
            verificarExistencia.depositar(valor);
            clienteTitular.depositoLocal(valor, numeroConta, this);
            verificarExistencia.extrato.add("deposito efetuado em: " +data+  " | " +valor+ " R$");
            System.out.println("deposito efetuado com sucesso");
        } else {
            System.out.println("deposito não foi efetuado");
        }
    }

    public void fazerSaque(float valor, String nomeDoTitular, Agencia agenciaDestino,
                 String numeroConta) {
        boolean contaExiste = checarConta(nomeDoTitular, agenciaDestino, numeroConta);
        if (!contaExiste) {
            System.out.println("Essa conta não existe aqui!");
        } else {
            Conta pegarConta = retornaConta(numeroConta, agenciaDestino);
            pegarConta.sacar(valor);
            pegarConta.extrato.add("saque efetuado" + " | " +data+ " | " +valor+ " R$");
            saqueAtualização(valor, numeroConta, this);
            System.out.println("saque efetuado com sucesso!");
        }
    }

    public void fazerTransferencia(float valor, String banese, Agencia minhaAgencia,
             String minhaConta, Cliente clienteDestino,
                 String numeroDaConta, String bancoDestino, Agencia agenciaDestino) {
        Conta verificarEmissor = retornaConta(minhaConta, minhaAgencia);
        Conta verificarReceptor = retornaConta(numeroDaConta, agenciaDestino);
        if (verificarEmissor != null && verificarReceptor != null) {
            if (verificarEmissor.saldo >= valor) {
                verificarEmissor.transferir(valor, verificarEmissor, verificarReceptor);
                transferenciaAtualizaçãoEmissor(valor, minhaConta, this);
                verificarEmissor.extrato.add("transferencia efetuada em: " +data+ " | conta destino: "
                +clienteDestino.nome+ " " +numeroDaConta+ " | " +valor+ " R$");
                verificarReceptor.extrato.add("transferencia efetuada em: " +data+ " | " + verificarEmissor.codigo 
                  +  " | " +valor+ " R$");
                System.out.println("Transferencia efetuada com sucesso");
                // transferenciaReceptor(valor, numeroDaConta, clienteDestino);
                clienteDestino.transferenciaAtualizaçãoReceptor(valor, clienteDestino, numeroDaConta);
            } else {
                System.out.println("transferecia negada, saldo insulficiente");
            }
        } else {
            System.out.println("Transferencia negada");
        }
    }

    // os próximo metados atualizam os valores locais do cliente. Por algum motivo
    // eles não atualizavam sozinhos
    private void depositoLocal(float valor, String numeroConta, Cliente cliente) {
        Conta minhaConta = retornaContaLocal(numeroConta, cliente);
        minhaConta.depositar(valor);
    }

    private Conta retornaContaLocal(String numeroConta, Cliente cliente) {

        for (int i = 0; i < minhasContas.size(); i++) {
            String atual = minhasContas.get(i).codigo;
            if (numeroConta == atual) {
                return minhasContas.get(i);
            }
        }
        return null;
    }

    private void saqueAtualização(float valor, String numeroConta, Cliente cliente) {
        Conta minhaConta = retornaContaLocal(numeroConta, cliente);
        minhaConta.extrato.add("saque efetuado" + " | " +data+ " | " +valor+ " R$");
        minhaConta.sacar(valor);
    }

    private void transferenciaAtualizaçãoEmissor(float valor, String numeroConta, Cliente emissor) {
        Conta minhaConta = retornaContaLocal(numeroConta, emissor);
        minhaConta.extrato.add("transferencia efetuada em: " +data+ " | conta destino: "
        +emissor.nome+ " " +numeroConta+ " | " +valor+ " R$");
        minhaConta.saldo = minhaConta.saldo - valor;
    }

    private void transferenciaAtualizaçãoReceptor(float valor, Cliente clienteDestino, String codigoConta) {
        Conta contaReceptor = clienteDestino.retornaContaLocal(codigoConta, clienteDestino);
        contaReceptor.extrato.add("transferencia efetuada em: " +data+ " | " + contaReceptor.codigo 
        +  " | " +valor+ " R$");
        contaReceptor.setSaldo(contaReceptor.saldo + valor);
    }

    public void gerarChavePix(Agencia agenciaDestino, String numeroDaConta) {
        Conta pegarConta = retornaConta(numeroDaConta, agenciaDestino);
        if (pegarConta == null) {
            System.out.println("Essa conta não existe");
        } else {
            System.out.println("ESCOLHA O TIPO DE CHAVE QUE DESEJA :\n" 
                + "- para email digite 1\n" +
                  "- para CPF digite 2\n" 
                + "- para ser um numero de telefone digite 3\n" +
                  "- para ser uma chave aleatória digite 4"
            );
            Scanner ler = new Scanner(System.in); int escolha = ler.nextInt();

            if (escolha == 1) {
                System.out.println("Digite seu email:\n");
                String chaveEMAIL = ler.nextLine();
                pegarConta.listaDepix.add(chaveEMAIL);
            } else if (escolha == 2) {
                pegarConta.listaDepix.add(cpf);
                System.out.println("Sua chave foi cadastrada:\n");             
            } else if (escolha == 3) {
                System.out.println("Digite seu numero de telefone:\n");
                String chaveTelefone = ler.nextLine();
                pegarConta.listaDepix.add(chaveTelefone);
            } else {
                PIX gerador = new PIX();
                gerador.gerarChaveAleatoria(pegarConta);
            }
            ler.close();
        }

    }
}
