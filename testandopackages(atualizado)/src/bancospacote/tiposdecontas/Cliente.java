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

// import bancospacote.*;


public final class Cliente {
    
    public String nome;
    public String cpf;
    public float saldo;
    // public Conta conta;
    // public List<Conta> contas;
    public Conta[] contas;
   

   public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;  
        this.contas = new Conta[3];  
    }
  
  /* public void addConta(String tipo,float saldo, String pix, String codigo, Agencia agencia){
        for(int i=0; i<agencia.contas.size(); i++){
            String codigo_conta = agencia.contas.get(i).codigo;
            if(codigo_conta.equals(codigo)){
                System.out.println("Você já tem uma conta nessa agência." + "\n" + "Você deseja mudar de tipo? S ou N");
                Scanner teclado = new Scanner(System.in);
                String resposta = teclado.next();
                if(resposta.equals("S")){
                    // Criaria um objeto e o tipo que o cliente queria e passaria os atributos do objeto antigo para o novo
                }
                    
                
            } */
   public void addConta(String tipo,String cliente,float saldo, String pix, String codigo, Agencia agencia){
        boolean temConta = checarConta(cliente, agencia);
        if(!temConta){
            this.addContaComplemento(tipo,cliente, saldo, pix, codigo, agencia);
            System.out.println("Conta criada com sucesso");
        }else{
            
            System.out.println("Você ja tem uma conta");
          /*  System.out.println("Já existe uma conta sua nessa agência." + "\n");
            System.out.println("Você deseja subtituir ela pela nova (o saldo das duas se somam, porem o resto altera)? S ou N");
            Scanner teclado = new Scanner(System.in);
            String resposta = teclado.next();
            if(resposta == "S"){
                saldo = 
            } */
        }
   }
   
   public boolean checarConta(String cliente, Agencia agencia){
       boolean temConta = false;
       for(int i=0; i<agencia.contas.size(); i++){
            String cliente_conta = agencia.contas.get(i).cliente;
            if(cliente_conta.equals(cliente)){
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
               

                                               
                                 
  
   

    // public void transferencia(Cliente clientedestino, float valortransferencia) {

    //     clientedestino.conta.setSaldo(valortransferencia + clientedestino.conta.saldo);
    //     conta.setSaldo(conta.saldo - valortransferencia);
        
    //     System.out.println("saldo atual destino: "+ clientedestino.conta.getSaldo());
    //     System.out.println("meu saldo atual: " + conta.getSaldo());
    // }

    // cadastrar pix 
    // public void cadastrarPix(Cliente inCliente) {
    //     System.out.println("Olá, para cadastar sua chavePix escolha as opções\n");
    //     System.out.println("1 para cpf\n" +
    //         "2 para email\n" +
    //         "3 para telefone\n" +
    //         "4 para gerar chave aleatoria"
    //     );

    //     if (inCliente.conta instanceof ContaCorrente) {
    //         ((inCliente.conta).pix) = "assombrado";
    //     } else if(inCliente.conta instanceof ContaPoupanca) {
    //         ((inCliente.conta).pix) = "açucar";
    //     } else {
    //         ((inCliente.conta).pix) = "biscoito";
    //     }
    // }

