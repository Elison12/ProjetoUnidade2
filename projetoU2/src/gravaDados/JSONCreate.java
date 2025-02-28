package gravaDados;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONCreate {

    public JSONArray lerJSON(String json) {
		// JSONObject jsonObject;
		JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("saida.json")) {
            Object obj = parser.parse(reader);

            JSONArray lista = (JSONArray) obj;
            return lista;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
	}

    public void gravaJSON(String numeroDaConta, String chave) {
        
		// JSONObject leitura = lerJSON("saida.json");
        JSONArray leitura = lerJSON("saida.json");
		
		FileWriter writerFile  = null;
        JSONObject objetoJson = new JSONObject();
		
        objetoJson.put(numeroDaConta, chave);
        JSONArray lista = new JSONArray();
        lista.addAll(leitura);
        lista.add(objetoJson);
        System.out.println(lista);
        try {
            writerFile = new FileWriter("saida.json");
            writerFile.write(lista.toJSONString());
            writerFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Verifica se A chave já existe na json, se já existe retorna true
    public boolean validacao(String chave) {
        JSONArray leitura = lerJSON("saida.json");
        ArrayList<String> listadechave = new ArrayList<String>();
        CharSequence sochave = null;

        for (int i = 0; i < leitura.size(); i++) {
            String converte =  String.valueOf(leitura.get(i));
            sochave = (String) converte.subSequence(9, converte.length() - 2);
            String novissima = String.valueOf(sochave);
            listadechave.add(novissima);
        }

        if (listadechave.contains(chave)) {
            return true;
        }
        return false;
    }
}
