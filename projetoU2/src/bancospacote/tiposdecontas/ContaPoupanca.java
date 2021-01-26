package bancospacote.tiposdecontas;

// import bancospacote.*

public class ContaPoupanca extends Conta implements Operacoes {

    public ContaPoupanca(String cliente,float saldo, String pix, String codigo, Agencia agencia) {
        super(cliente, saldo, pix, codigo);
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
}
