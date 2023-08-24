package beans;

import java.util.Date;
import main.Segurado;

public class Chamado {
    private static Date horaAtual = new Date();

    public static void retornarInformacoes() {
        System.out.println("----------------------------------------------");
        System.out.println("Essas são as informações do seu chamado:");
        System.out.println("Horário: " + horaAtual);
        System.out.println("Nome: " + Segurado.getNomeSegurado());
        System.out.println("CPF: " + Segurado.getCpf());
        System.out.println("Sinistro: " + Sinistro.getSinistroEscolhido());
        System.out.println("Endereço: " + Local.getRua() + ", " + Local.getNumero() + " - " + Local.getBairro());
        System.out.println("----------------------------------------------");

        Veiculo veiculo = new Veiculo("", 0, 0, "", 0, "");
        System.out.println("Essas são as informações do seu veículo:");
        System.out.println("Nome: " + veiculo.getNomeVeiculo());
        System.out.println("Ano: " + veiculo.getAno());
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Chassi: " + veiculo.getChassi());
        System.out.println("Peso: " + veiculo.getPeso());
        System.out.println("Altura: " + veiculo.getAltura());
        System.out.println("----------------------------------------------");

        System.out.println("Essas são as informações da carga:");
        System.out.println("Peso da carga: " + Carga.getPesoCarga());
        System.out.println("Tipo de carga: " + Carga.getTipoCarga());
        System.out.println("----------------------------------------------");

        IA ia = new IA();
        ia.selecionarModal();
        System.out.println("Modal determinado: " + ia.getModalSelecionado());
    }
}
