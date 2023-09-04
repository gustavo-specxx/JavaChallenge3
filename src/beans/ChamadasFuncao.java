package beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ChamadasFuncao {
	
	public ChamadasFuncao() {}
	
	public void abreChamado(String documentoSegurado) {
		/*System.out.println("Digite a hora do ocorrido");
		scan.next*/
		
		ChamadoDAO chamadoDAO = new ChamadoDAO();
		Scanner scan = new Scanner(System.in);

		int validaCham = chamadoDAO.validaChamado(documentoSegurado);
		
		System.out.println("entrou" + validaCham);
		
		if(validaCham == 1) {
			System.out.println("Já existem chamados em aberto, deseja continuar? S/N");
			String decisao = scan.next();
			
			if(decisao == "N") {
				
			}
			
		}
		
		LocalDate dataAtual = LocalDate.now();
		

		System.out.println("Digite o número de acordo com a sua situação:\\n[1]Batida [2]Pane Elétrica [3]Desastres Naturais");		
		int tipoSinistro = scan.nextInt();

		System.out.println("Nos dê uma descrição do que ocorreu");
		String descricaoChamado = scan.next();
		
		System.out.println("Digite o horário do acidente formato(HH:mm)");
		String horaSinistro = scan.next();
		
		LocalTime formHoraSinistro = null;
		
		   DateTimeFormatter formataHora = DateTimeFormatter.ofPattern("HH:mm");
		   
		   Boolean validaData = false;
		   
		   
		  /* while(validaData == false) {
	        try {
	             formHoraSinistro = LocalTime.parse(horaSinistro, formataHora);
	             validaData = true;
	             
	        } catch (Exception e) {
	            System.out.println("Digite um formato de hora Válido");
	            validaData = false;
	            //throw new Exception(e.getMessage());
	        }
		   }*/
		   
		   
		   Chamado novoChamado = new Chamado(formHoraSinistro,dataAtual,tipoSinistro,descricaoChamado,documentoSegurado);
		   System.out.println("Chamado aberto com sucesso! Em breve retornaremos com seu modal");
		   
		   
		 chamadoDAO.insereChamado(novoChamado);
		 
		 /* ArrayList<Chamado> os = chamadoDAO.retornaChamados(documentoSegurado);
		 
		 for(Chamado chamados: os) {
			 System.out.println("Descrição do chamado: " + chamados.getDescricaoChamado());
			 System.out.println(chamados.getTipoSinistro());
			 
		 }*/
		 
		
	}
	
	public void mostraChamados(String documentoSegurado) {
		ArrayList<Chamado> chamados = new ArrayList<>();
		
		ChamadoDAO chamadoDAO = new ChamadoDAO();
		
		
		chamados = chamadoDAO.retornaChamados(documentoSegurado);
		
		String tipoSinistro;
		
		for(Chamado chamado: chamados) {
			System.out.println("Tipo sinistro....: " + (tipoSinistro = (chamado.getTipoSinistro() == 1) ? "Batida"  :
																	(chamado.getTipoSinistro() == 2) ? "Pane"  :
																							"teste" )) ;
			System.out.println("Status do chamado : ");
			
		}
		
	}

}
	
	
	

