package bancospacote;

import bancospacote.tiposdecontas.Agencia;
import bancospacote.tiposdecontas.Conta;
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

    public void exibirMontante() {
           float montante = 0;
           for(int i = 0; i < this.agencias.size(); i++){
               Agencia agencia_cadastrada = this.agencias.get(i);
                 for(int x = 0; x < agencia_cadastrada.contas.size(); x++){
                   Conta conta_cadastrada = agencia_cadastrada.contas.get(x);
                   float saldo_conta = conta_cadastrada.getSaldo();
                   montante = saldo_conta + montante;
                 }              
            }   
           System.out.println("O montante do banco " + this.nome + " é de: " + montante);
    }
    
}
