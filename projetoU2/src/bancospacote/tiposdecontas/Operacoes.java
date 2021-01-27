package bancospacote.tiposdecontas;

public interface Operacoes {
    
    void depositar(float valor);
    void sacar(float valor);
    float verSaldo();
    void transferir(float valor, Conta minhaConta, Conta contaDestino);
}
