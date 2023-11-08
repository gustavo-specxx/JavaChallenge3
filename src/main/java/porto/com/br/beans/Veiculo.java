package porto.com.br.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Veiculo {
    private String nomeVeiculo;
    private int ano;
    
	@JsonProperty("PLACA_VEICULO")
    private String placa;
	
    private double altura;
    private String chassi;
    private String especificacoesVeiculo; 
	private String modeloVeiculo;
    private String tipoCarga; 
    private Double pesoCarga;
    
    public Veiculo(String nomeVeiculo, int ano, String placa, double altura, String chassi, String especificacoesVeiculo, String modeloVeiculo, String tipoCarga, Double pesoCarga) {
        this.nomeVeiculo = nomeVeiculo;
        this.ano = ano;
        this.placa = placa;
        this.altura = altura;
        this.chassi = chassi;
        this.especificacoesVeiculo = especificacoesVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.tipoCarga = tipoCarga;
        this.pesoCarga = pesoCarga;

    }
    
    public Veiculo() {}

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }



    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

	public void setEspecificacoesVeiculo(String especificacoesVeiculo) {
		this.especificacoesVeiculo = especificacoesVeiculo;
	}

	public String getEstadoVeiculo() {
		return null;
	}

	public String getEspecificacoesVeiculo() {
		return especificacoesVeiculo;
	}
    public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public void setEstadoVeiculo(String string) {
		
	}
	
    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }
    
    public double getPesoCarga() {
        return pesoCarga;
    }

    public void setPesoCarga (Double pesoCarga) {
        this.pesoCarga = pesoCarga;
    }
    
}