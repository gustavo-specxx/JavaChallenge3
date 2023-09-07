package beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChamadoDAO {
	
	Connection conn = new ConnectionFactory().criaConexao();
	
	
	public void insereChamado(Chamado chamado) {
		
		String sqlInsert = "Insert into TB_PSG_ORDEM_SERVICO (TIPO_SINISTRO,DESCRICAO_SINISTRO, DOCTO_SEGURADO) VALUES (?,?,?)";
		//DATA_SINISTRO
		try{
			
			PreparedStatement execInsert = conn.prepareStatement(sqlInsert);
			execInsert.setInt(1,chamado.getTipoSinistro());
			execInsert.setString(2,chamado.getDescricaoChamado());
			execInsert.setString(3,chamado.getDocumentoSegurado());
			
			execInsert.execute();
			execInsert.close();
				
		
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	public ArrayList<Chamado> retornaChamados(String doctoSegurado){
		ArrayList<Chamado> chamados = new ArrayList<>();			
			
		String sqlSelect = "Select * from tb_psg_ordem_servico where docto_segurado = "+ doctoSegurado;
		
		try {
			
			PreparedStatement selectChamado = conn.prepareStatement(sqlSelect) ;
			ResultSet rs = selectChamado.executeQuery();
			
			
			System.out.println(doctoSegurado);

			int v_teste;
			
			
			while(rs.next()) {
				Chamado chamado = new Chamado();
				
				chamado.setDescricaoChamado(rs.getString("DESCRICAO_SINISTRO"));
				chamado.setTipoSinistro(rs.getInt("TIPO_SINISTRO"));
				v_teste = rs.getInt("TIPO_SINISTRO");

				chamados.add(chamado);
			}
			selectChamado.close();
					
		}catch(SQLException e){
			throw new RuntimeException(e.getMessage());
					
			
		}
		
		
		return chamados;
		
	}
	
	public int validaChamado(String documentoSegurado) {
		
		String sqlSelect = "select count(1) from tb_psg_ordem_servico where docto_segurado = ? and status_os  != 'E'"; 
		
		int existeChamadoAberto;
		
		try {
			PreparedStatement query = conn.prepareStatement(sqlSelect);
			query.setString(1, documentoSegurado);
			
			
						
			ResultSet rs =  query.executeQuery();
			
			while(rs.next()) {
			existeChamadoAberto = rs.getInt(1);
				if(existeChamadoAberto == 0) {
					return 0;
					
				}else {
					return 1;	
				}							
			}
	
			
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
			
		}
		return 0;
		
	}
	
	
	
	public void fechaConexao() {
		try{
			conn.close();
		}catch(SQLException e) {
			
			throw new RuntimeException(e.getMessage());
			
		}	
	}
}
