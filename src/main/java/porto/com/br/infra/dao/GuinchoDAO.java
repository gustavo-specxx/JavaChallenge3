package porto.com.br.infra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import porto.com.br.beans.*;



public class GuinchoDAO {
    
    Connection conn = new ConnectionFactory().criaConexao();
    
  
    public int selecionaIdGuinchoEscolhido() {
       // ArrayList<Veiculo> veiculos = new ArrayList<>();
    	Guincho guincho = null;
    	
    	int idGuincho = 1; 
    	Random random = new Random();
    	
    	
        String sqlSelect = "select MAX(id_guincho) ID_GUINCHO"
        		+ "			from tb_psg_guincho"
        		+ "			where id_tipo_guincho = ?";
        try {
            PreparedStatement selectGuincho = conn.prepareStatement(sqlSelect);
            
            int randomTipoGuincho = random.nextInt(7) + 1;
            
            selectGuincho.setInt(1,randomTipoGuincho);

            ResultSet rs = selectGuincho.executeQuery();
            
            while (rs.next()) {
            	 idGuincho = rs.getInt("ID_GUINCHO");
            }
            
            selectGuincho.close();
            
            return idGuincho;
            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
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