package bancospacote.tiposdecontas;

// import bancospacote.*

public class ContaPoupanca extends Conta implements Operacoes {
    
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
    public float getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
