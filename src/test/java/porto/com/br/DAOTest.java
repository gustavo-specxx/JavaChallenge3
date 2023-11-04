package porto.com.br;

import org.junit.Before;
import org.junit.Test;

import porto.com.br.beans.Apolice;
import porto.com.br.beans.Chamado;
import porto.com.br.beans.Local;
import porto.com.br.beans.Veiculo;
import porto.com.br.infra.ViaCep.ViaCep;
import porto.com.br.infra.dao.*;
import porto.com.br.service.ChamadoService;
import porto.com.br.service.LocalService;
import porto.com.br.service.VeiculoService;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class DAOTest {
    private VeiculoDAO veiculoDAO;
    private ChamadoDAO chamadoDAO;
    private SeguradoDAO seguradoDAO;
    private ApoliceDAO apoliceDAO;
    private LocalDAO localDAO;
    private VeiculoService veiculoservice;
    
    


    @Before
    public void setUp() {
        // Inicialize objetos necessários antes de cada teste
        veiculoDAO = new VeiculoDAO();
        chamadoDAO = new ChamadoDAO();
        seguradoDAO = new SeguradoDAO();
        apoliceDAO = new ApoliceDAO();
        localDAO = new LocalDAO();
        veiculoservice = new VeiculoService();
        LocalService localService = new LocalService();
    }
    
    @Test
    public void retornoViacep() {
        ViaCep via = new ViaCep();
        Local local = null;
        
    	local = via.retornaLocalPesquisa("02123040");
    
    	System.out.println(local.getEndLocalSinistro());
    	
    	
    	
    }
    
   /* @Test
    public void verificaDAOChamado() {
    	
		ChamadoService servchamado = new ChamadoService();
		Chamado chamado = new Chamado(1, "AAAAAAAA", "17355056000161", 7, 6, null);
		servchamado.insereChamado(chamado, "17355056000161", 7, 6);
}
    */
    
    /* @Test
     public void verificaDAOChamado() {
    	
    		ChamadoService servchamado = new ChamadoService();
    	  ArrayList<Chamado> chamados = servchamado.retornaChamados("17355056000161");
    	  System.out.println(chamados);
    }
    
   
    
     @Test
    public void verificaLocalDAO() {
    	//Local local = new Local("Rua Arlindo Nogueira",null,"(Zona Norte) - até 1005/1006","64000290","Teresina","PI" );
    	
    	Local local = new Local("Rua x");
    	
    	localDAO.insereLocal(local);
    	
    	
    }
    
     @Test
    public void verificaRetornoID() {
    	seguradoDAO.retornaIdSegurado("17355056000161");
    	
    }*/
     /*  @Test
    public void testApoliceDAO() {
        // Teste os métodos da classe VeiculoDAO

        // Teste o método de inserção
        
    	int idx = 0;
    	
        ArrayList<Apolice> apolices = new ArrayList<>();
        apolices = apoliceDAO.retornaApoliceSegurado("17355056000161"); 
        for(Apolice apolice : apolices) {
            System.out.println("===========================");
            System.out.println("idx " + idx);
            System.out.println("Cobertura......: " + apolice.getCoberturaApolice());
            System.out.println("Codigo.....: " + apolice.getCodApolice());
            System.out.println("Tipo.:" + apolice.getTipoApolice());
            idx++;
        }
        
        System.out.println(apoliceDAO.retornaIdApolice(1, "17355056000161"));
        
        
       
        
    }*/
        
    
   /* @Test
   public void testVeiculoDAO() {
       // Teste os métodos da classe VeiculoDAO

       // Teste o método de inserção
       
     //  ArrayList<Veiculo> veiculos = new ArrayList<>();
       
    	Veiculo veiculos;
       veiculos = veiculoservice.selecionaVeiculoPelaPlaca("17355056000161", "KAL8923");
       
       /*for(Veiculo veiculo : veiculos) {
           System.out.println("===========================");
           System.out.println("Placa......: " + veiculo.getPlaca());
           System.out.println("Modelo.....: " + veiculo.getModeloVeiculo());
           System.out.println("Especificações.:" + veiculo.getEspecificacoesVeiculo());
       }
       
    }
       */
    /* @Test
    public void testVeiculoDAOaa() {
        // Teste os métodos da classe VeiculoDAO

        // Teste o método de inserção
        
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        veiculos = veiculoservice.selecionaVeiculoPelaPlaca("17355056000161", "KAL8923");
        for(Veiculo veiculo : veiculos) {
            System.out.println("===========================");
            System.out.println("Placa......: " + veiculo.getPlaca());
            System.out.println("Modelo.....: " + veiculo.getModeloVeiculo());
            System.out.println("Especificações.:" + veiculo.getEspecificacoesVeiculo());
        }
        
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC123");
        veiculo.setNomeVeiculo("Novo");
        veiculo.setEspecificacoesVeiculo("Especificações do veículo de teste");
        veiculoDAO.registraVeiculo(veiculo, idSegurado);
		

    }

     /* @Test
    public void testChamadoDAO() {
           
        Chamado chamado = new Chamado();

        String documentoSegurado = "123456789"; 
        chamadoDAO.insereChamado(chamado, documentoSegurado);

  
        ArrayList<Chamado> chamados = chamadoDAO.retornaChamados(documentoSegurado);
        assertNotNull(chamados);
        assertTrue(chamados.size() > 0);

        
    }*/
}