/*
- Essa é a primeira classe do projeto e a primeira no topo da hierarquia, não podemos instanciar objetos desse tipo.

- Tudo dps é herdado daqui, por enquanto 

- Por enquanto ela só tem um atributo que é um pix, provavelmente terá uma lista com os pix de todos os cliente  

-  Além de ter funções que vão gerar os pix aleatórios 
*/
package bancoCentral;

// import java.util.List;

public abstract class BancoCentral {
    
    // protected String Pix;

    // private List<classe> listaDePix;

    // listaDePix = new ArrayList<>();
    
 
    public String codigo;
    public float saldo; 
    public String nome;
    
    // exibirMontante()
    
    public String pix;
    
    public void cadastrarPix(){
        
    }
    
    public void mostrarDadosPix(){
        // não pode ter a mesma chave em varios bancos: email, chave automatica, ... . 
        // transferencia via pix vc passa a chave e ela identifica quem vai receber e mostra os dados
    }
    
    public void exibirMontante(){
        
    }
}
