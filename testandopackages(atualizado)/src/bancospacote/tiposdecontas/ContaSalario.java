package bancospacote.tiposdecontas;

public class ContaSalario extends Conta {

    public ContaSalario(Cliente cliente, float saldo, String pix, String codigo, Agencia agencia) {
        super(cliente, saldo, pix, codigo, agencia);

    }

    public void depisitarEmpregador(float valor) {
        setSaldo(saldo+valor);
    }
}

