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
                veiculo.setPlaca(rs.getString("PLACA_VEICULO"));
                veiculo.setModeloVeiculo(rs.getString("MODELO_VEICULO"));
                veiculo.setEspecificacoesVeiculo(rs.getString("ESPECIFICACOES_VEICULO"));
                veiculo.setAltura(rs.getDouble("ALTURA_VEICULO"));
                veiculo.setTipoCarga(rs.getInt("TIPO_CARGA"));
                veiculo.setPesoCarga(rs.getDouble("PESO_CARGA"));
                
               //  veiculo = new Veiculo(PlacaVeiculo, 0, 0, PlacaVeiculo, 0, documentoSegurado, PlacaVeiculo, sqlSelect, 0, 0);
            
                 veiculo = new Veiculo(".", 0, rs.getString("PLACA_VEICULO"), rs.getDouble("ALTURA_VEICULO")
                		 ,".", rs.getString("ESPECIFICACOES_VEICULO"), ".", rs.getInt("TIPO_CARGA"), rs.getDouble("PESO_CARGA"));
            }
            
            selectVeiculos.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        
        return veiculo;
    }
    /*public void registraVeiculo(Veiculo veiculo, int idSegurado) {
        String sqlInsert = "INSERT INTO tb_psg_veiculo (placa_veiculo, estado_veiculo, especificacoes_veiculo, TB_PSG_SEGURADO_ID_SEGURADO) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement execInsert = conn.prepareStatement(sqlInsert);
            execInsert.setString(1, veiculo.getPlaca());
            execInsert.setString(2, veiculo.getEstadoVeiculo());
            execInsert.setString(3, veiculo.getEspecificacoesVeiculo());
            execInsert.setInt(4, idSegurado);
            
            execInsert.execute();
            execInsert.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }*/

    /*public ArrayList<Veiculo> listaVeiculosApolice(String documentoSegurado, String PlacaVeiculo) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
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
                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(rs.getString("PLACA_VEICULO"));
                veiculo.setModeloVeiculo(rs.getString("MODELO_VEICULO"));
                veiculo.setEspecificacoesVeiculo(rs.getString("ESPECIFICACOES_VEICULO"));
                veiculo.setAltura(rs.getDouble("ALTURA_VEICULO"));
                veiculo.setTipoCarga(rs.getInt("TIPO_CARGA"));
                veiculo.setPesoCarga(rs.getDouble("PESO_CARGA"));
                veiculos.add(veiculo);
            }
            
            selectVeiculos.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        
        return veiculos;
    }*/

    public void fechaConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}