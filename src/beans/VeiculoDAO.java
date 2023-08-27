package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VeiculoDAO {
	
	
	public void registraVeiculo(Veiculo veiculo) {
		
		Connection conn = new ConnectionFactory().criaConexao();
		
		String sqlInsert = "Insert into tb_psg_veiculo(placa_veiculo,"
				+ ",estado_veiculo"
				+ ",especificacoes_veiculo"
				+ ","
				+ ""
				+ ""
				+ " values ( )";
		
		try {
			
			PreparedStatement insereVeiculo =  conn.prepareStatement(sqlInsert);
			
			insereVeiculo.setString(1, veiculo.getPlaca());
			insereVeiculo.setString(2,veiculo.getChassi());
			
			
			
			insereVeiculo.execute();
			insereVeiculo.close();
			
			
		
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());			
		}
		
	}
	
	/*public void fechaConVeiculo() {
		
		try {
			conn.close();
			
			
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
			
		};*/
		
		
	}
	
	
	
	
