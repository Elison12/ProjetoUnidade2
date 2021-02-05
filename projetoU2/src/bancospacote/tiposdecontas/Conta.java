package bancospacote.tiposdecontas;

import java.util.ArrayList;

public class Conta {

    public String cliente;
    protected float saldo;
    public String codigo;
    public ArrayList<String> extrato;
    public ArrayList<String> listaDepix;
 

    public Conta(String cliente, float saldo, String codigo) {
        this.saldo = saldo;
        this.codigo = codigo;
        this.cliente = cliente;
        extrato = new ArrayList<>();
        listaDepix = new ArrayList<>();
    }

    public void sacar(float valordesaque) {
        this.saldo = saldo - valordesaque;
    }

    public void depositar(float valordeposito) {
        System.out.println("depositou");
        this.saldo = saldo + valordeposito;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void transferir(float valor, Conta minhaConta, Conta contaDestino) {
        float destino = contaDestino.getSaldo();
        contaDestino.setSaldo(destino+valor);
        minhaConta.saldo = saldo - valor;
    }
}
