package porto.com.br.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Chamado {
    @JsonProperty("tipo")
    private int tipoSinistro;

    @JsonProperty("descricaoChamado")
    private String descricaoChamado;

    @JsonProperty("documentoSegurado")
    private String documentoSegurado;

    @JsonProperty("idApoliceSeguro")
    private int idApoliceSeguro;
    
    @JsonProperty("idLocalSinistro")
    private int idLocalSinistro;
    
    @JsonProperty("dataSinistro")
    private Date horaAtual;
    
    @JsonProperty("idVeiculo")
    private int idVeiculo;
    
    @JsonProperty("idGuincho")
    private int idGuincho;
    

    public Chamado() {
    }

    public Chamado(int tipoSinistro, String descricaoChamado, String documentoSegurado, int idApoliceSeguro, int idLocalSinistro, Date horaAtual, int idVeiculo, int idGuincho) {
        this.tipoSinistro = tipoSinistro;
        this.descricaoChamado = descricaoChamado;
        this.documentoSegurado = documentoSegurado;
        this.idApoliceSeguro = idApoliceSeguro;
        this.idLocalSinistro = idLocalSinistro;
        this.horaAtual = horaAtual;
        this.idVeiculo = idVeiculo;
        this.idGuincho = idGuincho;

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

    public int getIdApoliceSeguro() {
        return idApoliceSeguro;
    }

    public void setIdApoliceSeguro(int idApoliceSeguro) {
        this.idApoliceSeguro = idApoliceSeguro;
    }

    public int getIdLocalSinistro() {
        return idLocalSinistro;
    }

    public void setIdLocalSinistro(int idLocalSinistro) {
        this.idLocalSinistro = idLocalSinistro;
    }

    public Date getHoraAtual() {
        return horaAtual;
    }

    public void setHoraAtual(Date horaAtual) {
        this.horaAtual = horaAtual;
    }
    
    
    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    
    public int getIdGuincho() {
        return idGuincho;
    }

    public void setIdGuincho(int idGuincho) {
        this.idGuincho = idGuincho;
    }
  }
