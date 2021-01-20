

package bancospacote.tiposdecontas;

// import bancospacote.*

public class ContaPoupanca extends Conta implements Operacoes {

    public ContaPoupanca(Cliente cliente,float saldo, String pix, String codigo, Agencia agencia) {
        super(cliente, saldo, pix, codigo, agencia);

    }

   

    
    

    
         
    public void transferenciaPIX() {

    }

    @Override
    public void sacar(float valordesaque) {
        this.saldo = saldo - valordesaque;
    }

    //implementado da interface "Operacoes.java"
    @Override
    public void depositar(float valordeposito) {
        this.saldo = saldo + valordeposito;
    }

    @Override
    public float getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
