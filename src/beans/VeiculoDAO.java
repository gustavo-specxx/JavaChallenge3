package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
	public ArrayList<Veiculo> listaVeiculosApolice(String doctoSegurado){
		
		ArrayList<Veiculo> veiculo = new ArrayList<>();
		
		Connection conn = new ConnectionFactory().criaConexao();

		String sqlSelect = "Select placa_veiculo, especificacoes_veiculo, chassi_veiculo from tb_psg_veiculo where docto_segurado = " + doctoSegurado;
		
		
		try {
			PreparedStatement select = conn.prepareStatement(sqlSelect);
			ResultSet rs = select.executeQuery();
			
			while(rs.next()) {
				Veiculo nVeiculo = new Veiculo();
				nVeiculo.setPlaca(rs.getString("PLACA_VEICULO"));
				nVeiculo.setNomeVeiculo(rs.getString("ESPECIFICACOES_VEICULO"));
				nVeiculo.setChassi(rs.getString("CHASSI_VEICULO"));
				veiculo.add(nVeiculo);
			}
		
		
		
		}catch(SQLException e) {
			
			throw new RuntimeException(e.getMessage());
			
		}
		
		
		return veiculo;
		
	}
	
	
	
	/*public void fechaConVeiculo() {
		
		try {
			conn.close();
			
			
		} catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
			
		};*/
		
		
	}
	
	
	
	
