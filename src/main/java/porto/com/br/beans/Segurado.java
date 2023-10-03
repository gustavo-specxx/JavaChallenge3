package porto.com.br.beans;

import java.util.Scanner;

public class Segurado {

    private static String nomeSegurado;
    private static String cpf;
	private static Local umLocal;

    public Segurado(String nomeSegurado, String cpf) {
        Segurado.nomeSegurado = nomeSegurado;
        Segurado.cpf = cpf;
    }
    
   // public Segurado() {};

    static void abrirChamado() {
        Scanner leitor = new Scanner(System.in);

        Veiculo umVeiculo = new Veiculo("", 0, 0, "", 0, "");
        Sinistro umSinistro = new Sinistro();
        Carga umaCarga = new Carga();
        setUmLocal(new Local());

        umVeiculo.setNomeVeiculo("Onix");
        umVeiculo.setAno(2015);
        umVeiculo.setPeso(2.7);
        umVeiculo.setAltura(1.43);
        umVeiculo.setChassi("948728759873");

        umaCarga.setPesoCarga("68.3");
        umaCarga.setTipoCarga("Arroz");

        if (cpf == null || cpf.isEmpty()) {
            System.out.println("Insira seu CPF:");
            cpf = leitor.nextLine();
        }

       /* if (umSinistro.getDigitoSinistro() == null || umSinistro.getDigitoSinistro().isEmpty()) {
            System.out.println("Digite o número de acordo com a sua situação:\n[1]Batida [2]Pane Elétrica [3]Desastres Naturais");
            umSinistro.setDigitoSinistro(leitor.nextLine());
            umSinistro.escolhaSinistro();
        }

        if (umVeiculo.getPlaca() == null || umVeiculo.getPlaca().isEmpty()) {
            System.out.println("Insira a placa do Veículo:");
            umVeiculo.setPlaca(leitor.nextLine());
        }

        if (umaCarga.getPesoCarga() == null || umaCarga.getPesoCarga().isEmpty()) {
            System.out.println("Insira o peso da carga:");
            umaCarga.setPesoCarga(leitor.nextLine());
        }

        if (Local.getRua() == null || Local.getRua().isEmpty()) {
            System.out.println("Qual é o seu endereço? Insira o nome da rua:");
            Local.setRua(leitor.nextLine());
        }

        if (Local.getNumero() == null || Local.getNumero().isEmpty()) {
            System.out.println("Qual é o número?:");
            Local.setNumero(leitor.nextLine());
        }

        if (Local.getBairro() == null || Local.getBairro().isEmpty()) {
            System.out.println("Qual é o bairro?:");
            Local.setBairro(leitor.nextLine());
        }

        if (Local.getCep() == null || Local.getCep().isEmpty()) {
            System.out.println("Qual é o cep?:");
            Local.setCep(leitor.nextLine());
        }*/

     //   Chamado.retornarInformacoes();

        leitor.close();
    }

    public static String getNomeSegurado() {
        return nomeSegurado;
    }

    public static String getCpf() {
        return cpf;
    }

	public static Local getUmLocal() {
		return umLocal;
	}

	public static void setUmLocal(Local umLocal) {
		Segurado.umLocal = umLocal;
	}
}
