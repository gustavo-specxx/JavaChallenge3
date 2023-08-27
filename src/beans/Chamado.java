package beans;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Chamado {

	private static LocalTime horaAtual;
	private static LocalDate dataAtual;  
	private static int tipoSinistro;
	private static String descricaoChamado;
	private static String documentoSegurado;
	
	public Chamado(LocalTime horaAtual,LocalDate dataAtual, int tipoSinistro, String descricaoChamado, String documentoSegurado) {
		
		Chamado.horaAtual = horaAtual;
		Chamado.dataAtual = dataAtual;
		Chamado.tipoSinistro = tipoSinistro;
		Chamado.descricaoChamado = descricaoChamado;
		Chamado.documentoSegurado = documentoSegurado;
		
	}
	
	public Chamado() {
		
		
	}
	
	
	public static LocalDate getDataAtual() {
		return dataAtual;
	}

	public static void setDataAtual(LocalDate dataAtual) {
		Chamado.dataAtual = dataAtual;
	}
	
	public static LocalTime getHoraAtual() {
		return horaAtual;
	}

	public static void setHoraAtual(LocalTime horaAtual) {
		Chamado.horaAtual = horaAtual;
	}

	public static int getTipoSinistro() {
		return tipoSinistro;
	}

	public static void setTipoSinistro(int tipoSinistro) {
		Chamado.tipoSinistro = tipoSinistro;
	}

	public static String getDescricaoChamado() {
		return descricaoChamado;
	}

	public static void setDescricaoChamado(String descricaoChamado) {
		Chamado.descricaoChamado = descricaoChamado;
	}

	public static String getDocumentoSegurado() {
		return documentoSegurado;
	}

	public static void setDocumentoSegurado(String documentoSegurado) {
		Chamado.documentoSegurado = documentoSegurado;
	}
		
	/*public static void retornarInformacoes() {
		System.out.println("----------------------------------------------");
		
		System.out.println("Essas são as informações do seu chamado:");
		System.out.println("Horário: " + horaAtual);
		//System.out.println("Nome: " + Segurado.getNomeSegurado());
		//System.out.println("CPF: " + Segurado.getCpf());
		System.out.println("Sinistro: " + Sinistro.getSinistroEscolhido());
		System.out.println("Endereço: " + Local.getRua() + ", " + Local.getNumero() + " - " + Local.getBairro());
		
		System.out.println("----------------------------------------------");
		
		System.out.println("Essas são as informações do seu veículo:");
		System.out.println("Nome: " + Veiculo.getNomeVeiculo());
		System.out.println("Ano: " + Veiculo.getAno());
		//System.out.println("Placa: " + Veiculo.getPlaca());
		System.out.println("Chassi: " + Veiculo.getChassi());
		System.out.println("Peso: " + Veiculo.getPeso());
		System.out.println("Altura: " + Veiculo.getAltura());
		
		System.out.println("----------------------------------------------");
		
		System.out.println("Essas são as informações da carga:");
		System.out.println("Peso da carga: " + Carga.getTipoCarga());
		System.out.println("Tipo de carga: " + Carga.getPesoCarga());
		
		System.out.println("----------------------------------------------");
		IA.selecionarModal();
		System.out.println("Modal determinado: " + IA.getModalSelecionado());
		
	}*/

}
