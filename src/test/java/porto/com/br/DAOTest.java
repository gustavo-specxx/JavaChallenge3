package porto.com.br;

import org.junit.Before;
import org.junit.Test;

import porto.com.br.beans.Chamado;
import porto.com.br.beans.Veiculo;
import porto.com.br.dao.*;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class DAOTest {
    private VeiculoDAO veiculoDAO;
    private ChamadoDAO chamadoDAO;
    private SeguradoDAO seguradoDAO;
    
    


    @Before
    public void setUp() {
        // Inicialize objetos necessários antes de cada teste
        veiculoDAO = new VeiculoDAO();
        chamadoDAO = new ChamadoDAO();
        seguradoDAO = new SeguradoDAO();
    }	
    
    @Test
    public void verificaRetornoID() {
    	seguradoDAO.retornaIdSegurado("17355056000161");
    	
    }

    @Test
    public void testVeiculoDAO() {
        // Teste os métodos da classe VeiculoDAO

        // Teste o método de inserção
        
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        veiculos = veiculoDAO.listaVeiculosApolice("17355056000161"); 
        for(Veiculo veiculo : veiculos) {
            System.out.println("===========================");
            System.out.println("Placa......: " + veiculo.getPlaca());
            System.out.println("Modelo.....: " + veiculo.getModeloVeiculo());
            System.out.println("Especificações.:" + veiculo.getEspecificacoesVeiculo());
        }
        
        /*Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC123");
        veiculo.setNomeVeiculo("Novo");
        veiculo.setEspecificacoesVeiculo("Especificações do veículo de teste");
        veiculoDAO.registraVeiculo(veiculo, idSegurado);
		*/

    }

  /*  @Test
    public void testChamadoDAO() {
           
        Chamado chamado = new Chamado();

        String documentoSegurado = "123456789"; 
        chamadoDAO.insereChamado(chamado, documentoSegurado);

  
        ArrayList<Chamado> chamados = chamadoDAO.retornaChamados(documentoSegurado);
        assertNotNull(chamados);
        assertTrue(chamados.size() > 0);

        
    }*/
}