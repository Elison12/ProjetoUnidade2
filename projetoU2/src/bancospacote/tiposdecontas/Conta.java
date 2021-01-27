/*

- Herança da classe agencia

- tem um atributo que é o saldo, não sei se terá outros.

- algumas funções que estão sobre escritas nas classes "ContaCorrente, ContaPoupança e Contasalario que ainda não existe",
  assim.
  
- Organizar essas funções em uma interface dps

*/
package bancospacote.tiposdecontas;

import java.util.ArrayList;

public class Conta {

    public String cliente;
    protected float saldo;
    public String pix;
    // public Agencia agencia;
    public String codigo;
    public ArrayList<String> extrato;
 

    public Conta(String cliente, float saldo, String pix, String codigo) {
        this.saldo = saldo;
        this.pix = pix;
        this.codigo = codigo;
        this.cliente = cliente;
        extrato = new ArrayList<>();
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
