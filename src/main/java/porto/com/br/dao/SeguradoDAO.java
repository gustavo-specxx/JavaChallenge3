package porto.com.br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import porto.com.br.beans.Chamado;
import porto.com.br.beans.Segurado;

public class SeguradoDAO {
    Connection conn = new ConnectionFactory().criaConexao();

	public int retornaIdSegurado(String documentoSegurado) {
		String selectQuery = "select id_segurado from tb_psg_segurado where documento_segurado = ?";
		int idSegurado = 0; 
		try{
			
		PreparedStatement execSelect = conn.prepareStatement(selectQuery);
		
		execSelect.setString(1,documentoSegurado);
		
        ResultSet rs = execSelect.executeQuery();
        
        while(rs.next()) {
        idSegurado = (rs.getInt("ID_SEGURADO"));
        }
        
        return idSegurado;
        
		}catch(SQLException e) {
			throw new RuntimeException(e);
			
		}
		
	}
		
		public Segurado retornaSegurado(String doctoSegurado) {
	        Segurado segurado = null;

	        String sqlSelect = "SELECT NOME_SEGURADO, DOCUMENTO_SEGURADO FROM tb_psg_segurado WHERE DOCUMENTO_SEGURADO = ?";

	        try {
	            PreparedStatement selectSegurado = conn.prepareStatement(sqlSelect);
	            selectSegurado.setString(1, doctoSegurado);
	            ResultSet rs = selectSegurado.executeQuery();

	            while (rs.next()) {
	            	
	            	segurado = new Segurado (rs.getString("NOME_SEGURADO")
	            			,rs.getString("DOCUMENTO_SEGURADO")
	            			);
	            	
	            }
	            
	            selectSegurado.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e.getMessage());
	        }

	        return segurado;
	    }

		public void fechaConexao() {
			
			
		}
	}
