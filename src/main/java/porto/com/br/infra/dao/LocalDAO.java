package porto.com.br.infra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import porto.com.br.beans.Local;

public class LocalDAO {
	
    Connection conn = new ConnectionFactory().criaConexao();
	
	 public void insereLocal(Local local) {
	        String sql = "INSERT INTO TB_PSG_LOCAL_SINISTRO "
	        		+ "(ID_LOCAL_SINISTRO, "
	        		+ "END_LOCAL_SINISTRO, "
	        		+ "NUM_LOCAL_SINISTRO, "
	        		+ "PONTO_REF_LOCAL_SINISTRO, "
	        		+ "CEP_LOCAL_SINISTRO, "
	        		+ "LOCALIDADE, "
	        		+ "UF_LOCAL_SINISTRO) " 
	        		+ " VALUES (seq_id_local_sinistro.nextval, ?, ?, ?, ?, ?, ?)";

	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, local.getEndLocalSinistro());
	            pstmt.setString(2, local.getNumLocalSinistro());
	            pstmt.setString(3, local.getPontoRefLocalSinistro());
	            pstmt.setString(4, local.getCepLocalSinistro());
	            pstmt.setString(5, local.getLocalidade());
	            pstmt.setString(6, local.getUfLocalSinistro());

	            pstmt.execute();
	            pstmt.close();
	            
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	 
	    public void fechaConexao() {
	        try {
	            conn.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e.getMessage());
	        }
	    }

}
