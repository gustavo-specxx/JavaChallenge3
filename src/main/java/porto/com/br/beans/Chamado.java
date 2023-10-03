package porto.com.br.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Chamado {
	
	@JsonProperty("tipo")
    private int tipoSinistro;
	
	@JsonProperty
    private String descricaoChamado;
	
	@JsonProperty
    private String documentoSegurado;
	
	@JsonProperty
    private Date horaAtual;

    public Chamado() {
    }

    public Chamado(int tipoSinistro, String descricaoChamado, String documentoSegurado, Date horaAtual) {
        this.tipoSinistro = tipoSinistro;
        this.descricaoChamado = descricaoChamado;
        this.documentoSegurado = documentoSegurado;
        this.horaAtual = horaAtual;
    }

    public Chamado(Object object, Object object2, int tipoSinistro2, String descricaoChamado2,
			String documentoSegurado2) {
		
	}

	public int getTipoSinistro() {
        return tipoSinistro;
    }

    public void setTipoSinistro(int tipoSinistro) {
        this.tipoSinistro = tipoSinistro;
    }

    public String getDescricaoChamado() {
        return descricaoChamado;
    }

    public void setDescricaoChamado(String descricaoChamado) {
        this.descricaoChamado = descricaoChamado;
    }

    public String getDocumentoSegurado() {
        return documentoSegurado;
    }

    public void setDocumentoSegurado(String documentoSegurado) {
        this.documentoSegurado = documentoSegurado;
    }

    public Date getHoraAtual() {
        return horaAtual;
    }

    public void setHoraAtual(Date horaAtual) {
        this.horaAtual = horaAtual;
    }
}
