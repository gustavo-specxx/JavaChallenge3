package porto.com.br.infra.hereLocation;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HereLocation {


	import java.io.IOException;

	public class ConsultaLocalHEREAPIComOkHttp {
	    public static void main(String[] args) {
	        OkHttpClient client = new OkHttpClient();

	        String apiKey = "SUA_CHAVE_DE_API_HERE";
	        String cepPredefinido = "SEU_CEP_PREDEFINIDO";
	        String categoriaInteresse = "CATEGORIA_DE_INTERESSE";  // Por exemplo, "tow-truck" para guinchos

	        String url = "https://places.ls.hereapi.com/places/v1/discover/search" +
	                "?at=" + cepPredefinido +  // CEP predefinido
	                "&q=" + categoriaInteresse +  // Categoria de interesse
	                "&apiKey=" + apiKey;  // Sua chave de API

	        Request request = new Request.Builder()
	                .url(url)
	                .build();

	        try {
	            Response response = client.newCall(request).execute();
	            ResponseBody responseBody = response.body();
	            if (responseBody != null) {
	                String jsonResponse = responseBody.string();
	                System.out.println(jsonResponse);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


}
