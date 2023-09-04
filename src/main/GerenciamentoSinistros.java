package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import beans.ChamadasFuncao;
import beans.Chamado;
import beans.ChamadoDAO;
import beans.ConnectionFactory;
import beans.Segurado;

public class GerenciamentoSinistros {

	public static void main(String[] args) throws Exception{
			
		/*INSERIR MENU*/
		Scanner scan = new Scanner(System.in);

		 System.out.println("Digite seu documento");
		 String documentoSegurado = scan.next();
		 
		 documentoSegurado.replaceAll("\\s", "");
		 
		 Segurado novoSegurado = new Segurado("André",documentoSegurado);

		
			while(true) {
				System.out.println("1 - Abrir chamado");
				System.out.println("2 - Acompanhar Sinistro");
				System.out.println("3 - Meus chamados");
				System.out.println("5 - Encerrar programa");
				
				int opcao = scan.nextInt();
				ChamadasFuncao chamada = new ChamadasFuncao();
				
				switch(opcao){
				
					case 1:
						chamada.abreChamado(documentoSegurado);
						break;
						
					case 3:
						chamada.mostraChamados(documentoSegurado);
						
						
					}
				
						
				
				
				
				
			}
			
			
		/*System.out.println("Digite a hora do ocorrido");
		scan.next*/
			/* LocalDate dataAtual = LocalDate.now();

		System.out.println("Digite o tipo do sinistro");
		int tipoSinistro = scan.nextInt();
		
		System.out.println("Nos dê uma descrição do que ocorreu");
		String descricaoChamado = scan.next();
		
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
	            System.out.println("Digite um formato de hora Válido");
	            //throw new Exception(e.getMessage());
	        }
		   }
		   
		   Chamado novoChamado = new Chamado(formHoraSinistro,dataAtual,tipoSinistro,descricaoChamado,documentoSegurado);
		   
		 ChamadoDAO chamadoDAO = new ChamadoDAO();
		 chamadoDAO.insereChamado(novoChamado);
		 
		 ArrayList<Chamado> os = chamadoDAO.retornaChamados(documentoSegurado);
		 
		 for(Chamado chamados: os) {
			 System.out.println("Descrição do chamado: " + chamados.getDescricaoChamado());
			 System.out.println(chamados.getTipoSinistro());
			 
		 }
		 
		
	}*/

	}
	
}
