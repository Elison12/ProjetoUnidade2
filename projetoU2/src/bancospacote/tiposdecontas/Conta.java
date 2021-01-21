/*

- Herança da classe agencia

- tem um atributo que é o saldo, não sei se terá outros.

- algumas funções que estão sobre escritas nas classes "ContaCorrente, ContaPoupança e Contasalario que ainda não existe",
  assim.
  
- Organizar essas funções em uma interface dps

*/

package bancospacote.tiposdecontas;


public abstract class Conta  {

    public String cliente;
    public float saldo;
    public String pix;
    public Agencia agencia;
    public String codigo;

    public Conta(String cliente, float saldo, String pix, String codigo,Agencia agencia ) {
        this.saldo = saldo;
        this.pix = pix;
        this.codigo = codigo;
        this.agencia = agencia;
        this.cliente = cliente;

    }

    public void sacar(float valordesaque) {
        this.saldo = saldo - valordesaque;
    }

    public void depositar(float valordeposito) {
        this.saldo = saldo + valordeposito;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

}
