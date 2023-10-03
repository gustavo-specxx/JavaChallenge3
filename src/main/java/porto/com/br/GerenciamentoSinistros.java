package porto.com.br;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import porto.com.br.beans.ChamadasFuncao;
import porto.com.br.beans.Segurado;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Main class.
 *
 */
public class GerenciamentoSinistros {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example package
        final ResourceConfig rc = new ResourceConfig().packages("porto.com.br");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with endpoints available at "
                + "%s%nHit Ctrl-C to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }
}

/*public class GerenciamentoSinistros {

	public static void main(String[] args) throws Exception{
			
		/*INSERIR MENU*/
		/*Scanner scan = new Scanner(System.in);

		 System.out.println("Digite seu documento");
		 String documentoSegurado = scan.next();
		 
		 documentoSegurado.replaceAll("\\s", "");
		 
		 Segurado novoSegurado = new Segurado("André",documentoSegurado);

		
			while(true) {
				System.out.println("1 - Abrir chamado");
				System.out.println("2 - Acompanhar Sinistro");
				System.out.println("3 - Meus chamados");
				System.out.println("4 - Encerrar programa");
				
				int opcao = scan.nextInt();
				ChamadasFuncao chamada = new ChamadasFuncao();
				
				switch(opcao){
				
					case 1:
						chamada.abreChamado(documentoSegurado);
						break;
						
					case 3:
						chamada.mostraChamados(documentoSegurado);
						
						
					}
				
						
				
				
				
				
			}*/ //usar até aqui
			
			
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
		 
		
	}

	}
	
}*/
