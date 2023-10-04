package porto.com.br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
