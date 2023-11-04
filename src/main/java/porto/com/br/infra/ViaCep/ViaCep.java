package porto.com.br.infra.ViaCep;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import porto.com.br.beans.Local;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ViaCep {

	public Local retornaLocalPesquisa (String cepAlvo) {
		
	        OkHttpClient client = new OkHttpClient();
	        Local local = new Local();
	        
	        String url = "https://viacep.com.br/ws/"+cepAlvo+"/json";

	        Request request = new Request.Builder()
	                .url(url)
	                .method("GET", null)
	                .build();
	        
	        try {
	            Response response = client.newCall(request).execute();
	            
	            if(response.isSuccessful()) {
	            	String responseBody = response.body().string();
	            	System.out.println(responseBody);
	            	
                    JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();

	                local.setCepLocalSinistro(jsonObject.get("cep").getAsString());
	                local.setEndLocalSinistro(jsonObject.get("logradouro").getAsString());
	                local.setPontoRefLocalSinistro(jsonObject.get("complemento").getAsString());
	                local.setLocalidade(jsonObject.get("localidade").getAsString());
	                local.setUfLocalSinistro(jsonObject.get("uf").getAsString());
	            	
	            } else {
	            	
	            	System.out.println("Não foi possível obter o endereço através do cep " + cepAlvo + response.code());
	            	
	            }
	            
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	        
	        return local;
	    }
	}

