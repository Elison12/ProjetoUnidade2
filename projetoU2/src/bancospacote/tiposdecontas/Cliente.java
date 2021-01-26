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

public final class Cliente {
    
    public String nome;
    public String cpf;
    public ArrayList<Conta> minhasContas;
   
   public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;  
        minhasContas = new ArrayList<>(); 
    }
  
   public void addConta(String tipo,String cliente,float saldo, String pix, String codigo, Agencia agencia){
        boolean temConta = checarConta(cliente, agencia, codigo);
        if(!temConta){
            this.addContaComplemento(tipo, cliente, saldo, pix, codigo, agencia);
            System.out.println("Conta criada com sucesso");
        } else{   
            System.out.println("Você ja tem uma conta");
        }
   }
   
   public boolean checarConta(String cliente, Agencia agencia, String numeroConta){
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
    public Conta retornaConta(String numeroConta, Agencia essaAgencia) {

        for (int i = 0; i < essaAgencia.contas.size(); i++) {
            String atual = essaAgencia.contas.get(i).codigo;
            if (numeroConta == atual) {
                return essaAgencia.contas.get(i);
            }
        }
        return null;
    }

    public void addContaComplementoT(String tipo,String cliente, float saldo,
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


                
   public void addContaComplemento(String tipo, String cliente, float saldo,
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
            clienteTitular.depositoLocal(valor, numeroConta);
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
            saqueAtualização(valor, numeroConta);
            System.out.println("saque efetuado com sucesso!");
        }
    }

    //os próximo metados atualizam os valores locais do cliente. Por algum motivo eles não atualizavam sozinhos
    public void depositoLocal(float valor, String numeroConta) {
        Conta minhaConta = retornaContaLocal(numeroConta);
        minhaConta.depositar(valor);
    }

    public Conta retornaContaLocal(String numeroConta) {

        for (int i = 0; i < minhasContas.size(); i++) {
            String atual = minhasContas.get(i).codigo;
            if (numeroConta == atual) {
                return minhasContas.get(i);
            }
        }
        return null;
    }

    public void saqueAtualização(float valor, String numeroConta) {
        Conta minhaConta = retornaContaLocal(numeroConta);
        minhaConta.sacar(valor);
    }
}
