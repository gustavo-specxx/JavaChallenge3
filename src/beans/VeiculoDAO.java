package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO {
    
    Connection conn = new ConnectionFactory().criaConexao();
    
    public void registraVeiculo(Veiculo veiculo, int idSegurado) {
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
    }

    public ArrayList<Veiculo> listaVeiculosApolice(String documentoSegurado) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        String sqlSelect = "SELECT * FROM tb_psg_veiculo v INNER JOIN tb_psg_segurado s ON v.TB_PSG_SEGURADO_ID_SEGURADO = s.ID_SEGURADO WHERE s.DOCUMENTO_SEGURADO = ?";
        
        try {
            PreparedStatement selectVeiculos = conn.prepareStatement(sqlSelect);
            selectVeiculos.setString(1, documentoSegurado);
            ResultSet rs = selectVeiculos.executeQuery();
            
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(rs.getString("placa_veiculo"));
                veiculo.setEstadoVeiculo(rs.getString("estado_veiculo"));
                veiculo.setEspecificacoesVeiculo(rs.getString("especificacoes_veiculo"));
                veiculos.add(veiculo);
            }
            
            selectVeiculos.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        
        return veiculos;
    }

    public void fechaConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
