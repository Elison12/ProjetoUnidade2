/*
- Essa é a camada final da estrutura, ta marcada como final, assim não podemos criar mais filhas a partir daqui
- Nela setamos os atributos dos clientes
- Quando criamos um objeto desse tipo temos tbm o atributo pix que tá laaa na classe "BancoCentral", se pá ta errado
  mas coloquei pra fazer teste
- tem um atributo que é Conta, e veja q ele não ta no construtor, assim não aprecisamos dizer qual a conta
 do cliente no momento em que criamos el, só dps
 
- Tem aquele de um cliente pode ter mais de uma conta, possivelmente isso se tornará uma array de conta
*/
package bancospacote.tiposdecontas;

public final class Cliente {
    
    public String nome;
    public String cpf;
    public float saldo;
    public Conta[] contas;
   
   public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;  
        this.contas = new Conta[3];  
    }
  
   public void addConta(String tipo,String cliente,float saldo, String pix, String codigo, Agencia agencia){
        boolean temConta = checarConta(cliente, agencia);
        if(!temConta){
            this.addContaComplemento(tipo,cliente, saldo, pix, codigo, agencia);
            System.out.println("Conta criada com sucesso");
        } else{
            
            System.out.println("Você ja tem uma conta");
        }
   }
   
   public boolean checarConta(String cliente, Agencia agencia){
       boolean temConta = false;
       for(int i=0; i<agencia.contas.size(); i++){
            String cliente_conta = agencia.contas.get(i).cliente;
            if (cliente_conta.equals(cliente)) {
                temConta = true;
            }
       }
       return(temConta);
   }
                           
   public void addContaComplemento(String tipo,String cliente,float saldo, String pix, String codigo, Agencia agencia){
        if ("conta corrente".equals(tipo)) {
            this.contas[0] = new ContaCorrente(cliente,saldo, pix, codigo, agencia);   
            agencia.addConta(this.contas[0], agencia);
        } else if ("conta poupanca".equals(tipo)) {
            this.contas[1] = new ContaPoupanca(cliente,saldo, pix, codigo, agencia);      
            agencia.addConta(this.contas[1], agencia);
        } else {
            this.contas[2] = new ContaSalario(cliente,saldo, pix,codigo, agencia); 
            agencia.addConta(this.contas[2], agencia);
        }           
    }
}
