package bancospacote;

import bancospacote.tiposdecontas.Agencia;
import java.util.ArrayList;

public class Banco {

    public String codigo;
    public String nome;
    public ArrayList<Agencia> agencias;
    // public ArrayList<Agencia> agencias;

    public Banco(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        ArrayList<Agencia> agencias_lista = new ArrayList<>();
        this.agencias = agencias_lista;
    }

    public void exibirMontante() {}
    
}
