package beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChamadoDAO {
	
	Connection conn = new ConnectionFactory().criaConexao();
	
	
	public void insereChamado(Chamado chamado) {
		
		String sqlInsert = "Insert into TB_PSG_ORDEM_SERVICO (TIPO_SINISTRO,DESCRICAO_SINISTRO, DOCTO_SEGURADO) VALUES (?,?,?)";
		//DATA_SINISTRO
		try{
			
			PreparedStatement execInsert = conn.prepareStatement(sqlInsert);
			execInsert.setInt(1,chamado.getTipoSinistro());
			//execInsert.setDate(2, Date.valueOf(chamado.getHoraAtual()));
			execInsert.setString(2,chamado.getDescricaoChamado());
			execInsert.setString(3,chamado.getDocumentoSegurado());
			
			execInsert.execute();
			execInsert.close();
			System.out.println("Lançado com sucesso");
				
		
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
			
		}
	}
	
	
	public void fechaConexao() {
		try{
			conn.close();
		}catch(SQLException e) {
			
			throw new RuntimeException(e.getMessage());
			
		}
	
	}
	
	
	
}
