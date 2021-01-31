/*
- Herança de "conta"

- metados com a marcação @override são sobre escritos de conta, assim quando invocamos algum desse fazemos
  referencia as esses daqui, não da classe superior

- esses metados podem ser vistos na classe "Cliente"

*/
package bancospacote.tiposdecontas;

import java.util.ArrayList;

public class ContaCorrente extends Conta implements Operacoes {

    public ContaCorrente(String cliente, float saldo, String pix, String codigo, Agencia agencia) {
        super(cliente, saldo, pix, codigo);
        extrato = new ArrayList<>();
        listaDepix = new ArrayList<>();
    }
    
    public void transferenciaPIX() {

    }

    @Override
    public void sacar(float valordesaque) {
        this.saldo = saldo - valordesaque;
    }
    //implementado da interface "Operações.java"
    @Override
    public void depositar(float valordeposito) {
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
