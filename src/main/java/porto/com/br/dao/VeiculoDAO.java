package porto.com.br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import porto.com.br.beans.*;



public class VeiculoDAO {
    
    Connection conn = new ConnectionFactory().criaConexao();
    
  
    public Veiculo selecionaVeiculoPelaPlaca(String documentoSegurado, String PlacaVeiculo) {
       // ArrayList<Veiculo> veiculos = new ArrayList<>();
    	Veiculo veiculo = null;
    	
        String sqlSelect = "select veic.placa_veiculo"
                + ", tipv.modelo_veiculo"
                + ", veic.ESPECIFICACOES_VEICULO"
                + ", veic.estado_veiculo"
                + ",  tipv.altura_veiculo"
                + ", veic.tipo_carga"
                + ", veic.peso_carga"
                + " from tb_psg_apolice_seguro apol"
                + ",    tb_psg_veiculo veic"
                + ",    tb_psg_veiculo_apolice veia"
                + ",    tb_psg_tipo_veiculo tipv"
                + " where apol.id_segurado = ? "
                + " and   apol.apolice_ativa      = 1 "
                + " and   veic.placa_veiculo = ?"
                + " and   apol.id_apolice_seguro  = veia.id_apolice_seguro "
                + " and   veic.id_veiculo         = veia.id_veiculo "
                + " and   veic.id_tipo_veiculo    = tipv.id_tipo_veiculo";
        try {
            PreparedStatement selectVeiculos = conn.prepareStatement(sqlSelect);
            SeguradoDAO seguradoDAO = new SeguradoDAO();
            
            selectVeiculos.setInt(1,seguradoDAO.retornaIdSegurado(documentoSegurado));
            selectVeiculos.setString(2,PlacaVeiculo);

            ResultSet rs = selectVeiculos.executeQuery();
            
            while (rs.next()) {
                 veiculo = new Veiculo(".", 0, rs.getString("PLACA_VEICULO"), rs.getDouble("ALTURA_VEICULO")
                		 ,".", rs.getString("ESPECIFICACOES_VEICULO"), ".", rs.getString("TIPO_CARGA"), rs.getDouble("PESO_CARGA"));
            }
            
            selectVeiculos.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        
        return veiculo;
    }
    
  
    public void fechaConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}