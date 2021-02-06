package bancospacote.tiposdecontas;

public interface PIXoperacoes {

    public void gerarChavePix(Agencia agencia, String conta);
    public void validarChave(String conta, String chave);
}
