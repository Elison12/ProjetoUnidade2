package bancospacote.tiposdecontas;

import java.util.ArrayList;

public class ContaSalario extends Conta {

    public ContaSalario(String cliente, float saldo, String pix, String codigo, Agencia agencia) {
        super(cliente, saldo, pix, codigo);
        extrato = new ArrayList<>();
    }

    public void depisitarEmpregador(float valor) {
        setSaldo(saldo+valor);
    }

    public float verSaldo() {
        return saldo;
    }

    public void sacar(float valordesaque) {
        this.saldo = saldo - valordesaque;
    }

    public void transferir(float valor, Conta minhaConta, Conta contaDestino) {
        float destino = contaDestino.getSaldo();
        contaDestino.setSaldo(destino+valor);
        minhaConta.saldo = saldo - valor;
    }
}
