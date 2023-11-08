package porto.com.br.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Local {
	
	@JsonProperty("LOGRADOURO")
    private String endLocalSinistro;
	
	@JsonProperty("NUMERO")
    private String numLocalSinistro;
	
	@JsonProperty("COMPLEMENTO")
    private String pontoRefLocalSinistro;
	
	@JsonProperty("CEP")
    private String cepLocalSinistro;
	
	@JsonProperty("LOCALIDADE")
    private String localidade;
	
	@JsonProperty("UF")
    private String ufLocalSinistro;

    public Local(String endLocalSinistro, String numLocalSinistro, String pontoRefLocalSinistro,
                 String cepLocalSinistro, String localidade, String ufLocalSinistro) {
    	
        this.endLocalSinistro = endLocalSinistro;
        this.numLocalSinistro = numLocalSinistro;
        this.pontoRefLocalSinistro = pontoRefLocalSinistro;
        this.cepLocalSinistro = cepLocalSinistro;
        this.localidade = localidade;
        this.ufLocalSinistro = ufLocalSinistro;
    }
	
	public Local(){}

    public String getEndLocalSinistro() {
        return endLocalSinistro;
    }

    public void setEndLocalSinistro(String endLocalSinistro) {
        this.endLocalSinistro = endLocalSinistro;
    }

    public String getNumLocalSinistro() {
        return numLocalSinistro;
    }

    public void setNumLocalSinistro(String numLocalSinistro) {
        this.numLocalSinistro = numLocalSinistro;
    }

    public String getPontoRefLocalSinistro() {
        return pontoRefLocalSinistro;
    }

    public void setPontoRefLocalSinistro(String pontoRefLocalSinistro) {
        this.pontoRefLocalSinistro = pontoRefLocalSinistro;
    }

    public String getCepLocalSinistro() {
        return cepLocalSinistro;
    }

    public void setCepLocalSinistro(String cepLocalSinistro) {
        this.cepLocalSinistro = cepLocalSinistro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUfLocalSinistro() {
        return ufLocalSinistro;
    }

    public void setUfLocalSinistro(String ufLocalSinistro) {
        this.ufLocalSinistro = ufLocalSinistro;
    }
}

