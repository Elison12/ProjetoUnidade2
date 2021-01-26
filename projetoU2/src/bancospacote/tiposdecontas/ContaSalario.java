package bancospacote.tiposdecontas;

public class ContaSalario extends Conta {

    public ContaSalario(String cliente, float saldo, String pix, String codigo, Agencia agencia) {
        super(cliente, saldo, pix, codigo);
    }

    public void depisitarEmpregador(float valor) {
        setSaldo(saldo+valor);
    }
}
