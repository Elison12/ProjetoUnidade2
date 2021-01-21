package bancospacote.tiposdecontas;
/*
- Essa daqui provavelmente terá uma lista com os cliente dessa agencia
*/
import bancospacote.Banco;
import java.util.ArrayList;
import java.util.List;


public class Agencia  {

    public String codigo;
    public String nome;
    public List<Conta> contas;


    public Agencia(String nome, String codigo, Banco banco) {
        this.nome = nome;
        this.codigo = codigo;
        List<Conta> contas_lista = new ArrayList<>();
        this.contas = contas_lista;
        addNewAgencia(this, banco);      
    }

    public void addConta(Conta conta, Agencia agencia) {
        agencia.contas.add(conta);
    }

    public void addNewAgencia(Agencia novAgencia, Banco mybanco) {
        mybanco.agencias.add(novAgencia);
    }

}