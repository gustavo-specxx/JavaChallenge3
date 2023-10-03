package porto.com.br.beans;

public class Veiculo {
    private String nomeVeiculo;
    private int ano;
    private double peso;
    private String placa;
    private double altura;
    private String chassi;
    
    public Veiculo(String nomeVeiculo, int ano, double peso, String placa, double altura, String chassi) {
        this.nomeVeiculo = nomeVeiculo;
        this.ano = ano;
        this.peso = peso;
        this.placa = placa;
        this.altura = altura;
        this.chassi = chassi;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
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

	public void setEspecificacoesVeiculo(String string) {
		
	}

	public String getEstadoVeiculo() {
		return null;
	}

	public String getEspecificacoesVeiculo() {
		return null;
	}

	public void setEstadoVeiculo(String string) {
		
	}
}