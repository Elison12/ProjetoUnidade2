
package bancospacote.tiposdecontas;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Map;
import bancoCentral.PIX;
import gravaDados.*;

public final class Cliente implements PIXoperacoes {
    
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
            minhasContas.add(new ContaCorrente(cliente, saldo, codigo, agencia));
            agencia.contas.add(new ContaCorrente(cliente, saldo, codigo, agencia));
        } else if ("conta poupanca".equals(tipo)) {
            minhasContas.add(new ContaPoupanca(cliente, saldo, codigo, agencia));
            agencia.contas.add(new ContaPoupanca(cliente, saldo, codigo, agencia));
        } else {
            minhasContas.add(new ContaSalario(cliente, saldo, codigo, agencia));
            agencia.contas.add(new ContaSalario(cliente, saldo,
             codigo, agencia));
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
            Scanner ler = new Scanner(System.in); 
            int escolha = ler.nextInt();
            Scanner leitura = new Scanner(System.in);
            
            
            if (escolha == 1) {
                System.out.println("Digite seu email:\n");
                String entrada = leitura.nextLine();
                if (validarChave(numeroDaConta, entrada) == true) {
                    System.out.println("Essa chave já existe, escolha outra");
                } else {
                    pegarConta.listaDepix.add(entrada);
                    JSONCreate gravar0 = new JSONCreate();
                    gravar0.gravaJSON(numeroDaConta, entrada);
                    System.out.println("Sua chave foi cadastrada:\n"); 
                }
                  
            } else if (escolha == 2) {
                if (validarChave(numeroDaConta, cpf) == true) {
                    System.out.println("Essa chave já existe, escolha outra");
                } else {
                    pegarConta.listaDepix.add(cpf);
                    JSONCreate gravar1 = new JSONCreate();
                    gravar1.gravaJSON(numeroDaConta, cpf);
                    System.out.println("Sua chave foi cadastrada:\n"); 
                }

            } else if (escolha == 3) {
                System.out.println("Digite seu numero de telefone:\n");
                String entrada = leitura.nextLine();
                if (validarChave(numeroDaConta, entrada) == true) {
                    System.out.println("Essa chave já existe, escolha outra");
                } else {
                    pegarConta.listaDepix.add(entrada);
                    JSONCreate gravar2 = new JSONCreate();
                    gravar2.gravaJSON(numeroDaConta, entrada);
                    System.out.println("Sua chave foi cadastrada:\n"); 
                }

            } else {
                PIX gerador = new PIX();
                String chaveGerada = gerador.gerarChaveAleatoria(pegarConta);
                JSONCreate gravar3 = new JSONCreate();
                gravar3.gravaJSON(numeroDaConta, chaveGerada);
            }
        }
    }

    @Override
    public boolean validarChave(String conta, String chave) {
        JSONCreate jc = new JSONCreate();
        // System.out.println(jc.validacao(chave));
        boolean confere = jc.validacao(chave);
        if (confere == true) {
            return true;
        } 
        return false;
    }
}
