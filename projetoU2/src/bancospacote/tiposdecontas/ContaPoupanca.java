package bancospacote.tiposdecontas;

import java.util.ArrayList;


public class ContaPoupanca extends Conta implements Operacoes {

    public ContaPoupanca(String cliente,float saldo, String pix, String codigo, Agencia agencia) {
        super(cliente, saldo, pix, codigo);
        extrato = new ArrayList<>();
        listaDepix = new ArrayList<>();
    }
 
    public void transferenciaPIX() {}

    @Override
    public void sacar(float valordesaque) {
        this.saldo = saldo - valordesaque;
    }

    //implementado da interface "Operacoes.java"
    @Override
    public void depositar(float valordeposito) {
        System.out.println("Depositou");
        this.saldo = saldo + valordeposito;
    }

    @Override
    public float verSaldo() {
        return saldo;
    }

    @Override
    public void transferir(float valor, Conta minhaConta, Conta contaDestino) {
        float destino = contaDestino.getSaldo();
        contaDestino.setSaldo(destino+valor);
        minhaConta.saldo = saldo - valor;
    }
}
