package porto.com.br.beans;

import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Segurado {
	
	@JsonProperty("NOME_SEGURADO")
    private  String nomeSegurado;
	
	@JsonProperty("DOCUMENTO_SEGURADO")
    private  String cpf;
	

    public Segurado(String nomeSegurado, String cpf) {
        this.nomeSegurado = nomeSegurado;
        this.cpf = cpf;
    }
    
    public  String getNomeSegurado() {
        return nomeSegurado;
    }

    public  String getCpf() {
        return cpf;
    }
	
	public void setNomeSegurado(String nomeSegurado) {
		this.nomeSegurado = nomeSegurado;
	}
	
	public void setDocumentoSegurado (String doctoSegurado) {
		this.cpf = doctoSegurado;
	}
}
