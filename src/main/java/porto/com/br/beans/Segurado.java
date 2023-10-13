package porto.com.br.beans;

import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Segurado {
	
	@JsonProperty("NOME_SEGURADO")
    private  String nomeSegurado;
	
	@JsonProperty("DOCUMENTO_SEGURADO")
    private  String cpf;
	
	/*@JsonProperty
	private  Local umLocal;*/

    public Segurado(String nomeSegurado, String cpf) {
        this.nomeSegurado = nomeSegurado;
        this.cpf = cpf;
    }
    
    
   // public Segurado() {};



    public  String getNomeSegurado() {
        return nomeSegurado;
    }

    public  String getCpf() {
        return cpf;
    }

	/*public  Local getUmLocal() {
		return umLocal;
	}

	public static void setUmLocal(Local umLocal) {
		this.umLocal = umLocal;
	}
	*/
	
	public void setNomeSegurado(String nomeSegurado) {
		this.nomeSegurado = nomeSegurado;
	}
	
	public void setDocumentoSegurado (String doctoSegurado) {
		this.cpf = doctoSegurado;
	}
}
