package bancospacote.tiposdecontas;

public class ContaSalario extends Conta {

    public void depisitarEmpregador(float valor) {
        setSaldo(saldo+valor);
    }
}
