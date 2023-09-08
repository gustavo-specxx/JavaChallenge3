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

		ChamadoDAO chamadoDAO = new ChamadoDAO();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		ArrayList<Veiculo> veiculo = new ArrayList<>();
		
		
		
		Scanner scan = new Scanner(System.in);

		int validaCham = chamadoDAO.validaChamado(documentoSegurado);
		
		if(validaCham == 1) {
			System.out.println("Já existem chamados em aberto, deseja continuar? S/N");
			String decisao = scan.next();
			
			if(decisao == "N") {
				//Retornar ao menu
				
			}
			
		}
		
		System.out.println("Digite o número de acordo com a sua situação:\\n1- Colisão, 2-Roubo/Furto, 3-Incêndio, 4-Desastres naturais, 5-Reparo vidros");		
		int tipoSinistro = scan.nextInt();

		System.out.println("Descreva o ocorrido");
		String descricaoChamado = scan.next(); 
		
        System.out.println("Insira a placa do Veículo envolvido no acidente:");
        veiculo = veiculoDAO.listaVeiculosApolice(documentoSegurado);
        
        for(Veiculo veic: veiculo) {
        	System.out.println("===========*=========*=======");
        	System.out.println("Placa......: " + veic.getPlaca());
        	System.out.println("Descrição..: " + veic.getNomeVeiculo());
        	System.out.println("Chassi.....:" + veic.getChassi()); }
        
        
        String veiculoSelecionado = scan.next();
        
        //Decisão: Usar API ou digitar localização (?)
        System.out.println("Qual é o seu endereço? Insira o nome da rua:");
        Local.setRua(scan.nextLine());
        
        System.out.println("Qual é o número?:");
        Local.setNumero(scan.nextLine());
        
        System.out.println("Qual é o bairro?:");
        Local.setBairro(scan.nextLine());
        
        System.out.println("Qual é o cep?:");
        Local.setCep(scan.nextLine());
        
   
		   
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
		   
		   
		   Chamado novoChamado = new Chamado(null,null,tipoSinistro,descricaoChamado,documentoSegurado);
		  
		   chamadoDAO.insereChamado(novoChamado);

		   System.out.println("Chamado aberto com sucesso! Em breve retornaremos com atualizações");
		   chamadoDAO.fechaConexao();
		   
		 
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
		
		int tipoSinistro;
				
		if(chamados.isEmpty()) {
			
			
			System.out.println("Não há chamados para mostrar.");
			
		}else {
			System.out.println("=========CHAMADOS=======");
			int v_count = 0;

		for(Chamado chamado: chamados) {
			
			
			   tipoSinistro = chamado.getTipoSinistro();
			    String tipoSinistroTexto;

			    switch (tipoSinistro) {
			        case 1:
			            tipoSinistroTexto = "Colisão";
			            break;
			        case 2:
			            tipoSinistroTexto = "Roubo/Furto";
			            break;
			        case 3:
			            tipoSinistroTexto = "Incêndio";
			            break;
			        case 4:
			            tipoSinistroTexto = "Desastre Natural";
			            break;
			        case 5:
			            tipoSinistroTexto = "Reparo de Vidros";
			            break;
			        default:
			            tipoSinistroTexto = "Não Identificado";
			            break;
			    }
			    
			    System.out.println("Tipo Sinistro....: " + tipoSinistroTexto);
			    
			    v_count = v_count + 1;
			    
			    System.out.println(tipoSinistro);
			}
		}
		chamadoDAO.fechaConexao();
			
		
	}

}
	
	
	

