package bancospacote.tiposdecontas;

/*

- Essa daqui provavelmente terá uma lista com os cliente dessa agencia

*/
import bancospacote.Banco;
import java.util.ArrayList;
import java.util.List;

public class Agencia extends Banco {
     
    public List<Conta> contas;
    public Banco banco;
    
    public Agencia(String nome, String codigo, Banco banco) {
        super(nome, codigo);
        // Sempre que criar uma agencia ela vai ter um arraylist no atributo clientes
        // sempre q um cliente pertencer a essa agencia ele vai ser adicionado nesse atributo
        List<Conta> contas_lista = new ArrayList<>();
        this.contas = contas_lista;
        this.banco = banco;
        this.banco.addAgencia(this, banco);
    }

    
    @Override
    public void exibirMontante(){
        
    }
    
    public void addConta(Conta conta, Agencia agencia){
        agencia.contas.add(conta);
    }


}
