package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import beans.Chamado;
import beans.ChamadoDAO;
import beans.ConnectionFactory;
import beans.Segurado;

public class GerenciamentoSinistros {

	public static void main(String[] args) throws Exception{
			
		/*INSERIR MENU*/
		
		Segurado novoSegurado = new Segurado("André","12345678910");
		
			Scanner scan = new Scanner(System.in);
		
		/*System.out.println("Digite a hora do ocorrido");
		scan.next*/
        LocalDate dataAtual = LocalDate.now();

		System.out.println("Digite o tipo do sinistro");
		int tipoSinistro = scan.nextInt();
		
		System.out.println("Nos dê uma descrição do que ocorreu");
		String descricaoChamado = scan.next();
		
		System.out.println("Digite o cpf do segurado");
		String documentoSegurado = scan.next();
		
		System.out.println("Digite o horário do acidente formato(HH:mm)");
		String horaSinistro = scan.next();
		
		LocalTime formHoraSinistro = null;
		
		   DateTimeFormatter formataHora = DateTimeFormatter.ofPattern("HH:mm");
		   
		   Boolean validaData = false;
		   
		   
		   while(validaData == false) {
	        try {
	             formHoraSinistro = LocalTime.parse(horaSinistro, formataHora);
	             validaData = true;
	             
	        } catch (Exception e) {
	            validaData = false;
	            throw new Exception(e.getMessage());
	        }
		   }
		   
		   Chamado novoChamado = new Chamado(formHoraSinistro,dataAtual,tipoSinistro,descricaoChamado,documentoSegurado);
		   
		 ChamadoDAO chamadoDAO = new ChamadoDAO();
		 chamadoDAO.insereChamado(novoChamado);
		
		
	}

}
