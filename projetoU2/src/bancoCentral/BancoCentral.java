
package bancoCentral;

// import java.util.List;

public abstract class BancoCentral {
    
    public String codigo;
    public float saldo; 
    public String nome;
    
    public void cadastrarPix() {
        
    }
    
    public void mostrarDadosPix() {
        // não pode ter a mesma chave em varios bancos: email, chave automatica, ... . 
        // transferencia via pix vc passa a chave e ela identifica quem vai receber e mostra os dados
    }
    
    public void exibirMontante() {
        
    }
}
