package bancoCentral;

import java.util.ArrayList;
import java.util.UUID;
import bancospacote.tiposdecontas.Agencia;
import bancospacote.tiposdecontas.Conta;

public class  PIX extends BancoCentral implements GerenciaPix {

    public ArrayList<Conta> listaGlobalPIX;
    public ArrayList<Agencia> listaDeAgencias;
    
	public PIX() {
		listaGlobalPIX = new ArrayList<>();
	}  

    @Override
    public void gerarChaveAleatoria(Conta conta) {
        String novaChave = generateString();
        conta.listaDepix.add(novaChave);
    }

    private static String generateString() {
        String uuid = UUID.randomUUID().toString();
        uuid.replace("", "");
        System.out.println("sua chave eh: " + uuid);
        return uuid;
    }
  
}
