/*

- Essa daqui herda de banco central, por enquanto vazia

*/
package bancospacote;

import bancoCentral.*;
import bancospacote.tiposdecontas.Agencia;
import java.util.ArrayList;
import java.util.List;

public class Banco extends BancoCentral {       
    

    public List<Agencia> agencias;
    
    public Banco(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        List<Agencia> agencias_lista = new ArrayList<>();
        this.agencias = agencias_lista;
    }      
    
    @Override
    public void exibirMontante(){
        
    }
    
    public void addAgencia(Agencia agencia,Banco banco){
        banco.agencias.add(agencia);
    }
}
