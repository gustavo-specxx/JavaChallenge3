package porto.com.br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import porto.com.br.beans.Chamado;


public class ChamadoDAO {
    Connection conn = new ConnectionFactory().criaConexao();

    public void insereChamado(Chamado chamado, String documentoSegurado) {
        String sql = "INSERT INTO TB_PSG_ORDEM_SERVICO (TIPO_SINISTRO, DESCRICAO_SINISTRO, DOCTO_SEGURADO) VALUES (?, ?, ?)";
        
        try (//Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
        	String desc_chamado = (chamado.getDescricaoChamado()!= null) ? chamado.getDescricaoChamado() : "CHAMADO";
        	
            pstmt.setInt(1, chamado.getTipoSinistro());
            pstmt.setString(2, desc_chamado);
            pstmt.setString(3, documentoSegurado); // Defina o documento do segurado aqui
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Connection getConnection() {
		
		return null;
	}


	public ArrayList<Chamado> retornaChamados(String doctoSegurado) {
        ArrayList<Chamado> chamados = new ArrayList<>();

        String sqlSelect = "SELECT * FROM tb_psg_ordem_servico WHERE docto_segurado = ?";

        try {
            PreparedStatement selectChamado = conn.prepareStatement(sqlSelect);
            selectChamado.setString(1, doctoSegurado);
            ResultSet rs = selectChamado.executeQuery();

            while (rs.next()) {
                Chamado chamado = new Chamado();
                chamado.setDescricaoChamado(rs.getString("DESCRICAO_SINISTRO"));
                chamado.setTipoSinistro(rs.getInt("TIPO_SINISTRO"));
                chamados.add(chamado);
            }
            
            selectChamado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return chamados;
    }

    public int validaChamado(String documentoSegurado) {
        String sqlSelect = "SELECT COUNT(1) FROM tb_psg_ordem_servico WHERE docto_segurado = ? AND status_os != 'E'";
        int existeChamadoAberto;

        try {
            PreparedStatement query = conn.prepareStatement(sqlSelect);
            query.setString(1, documentoSegurado);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                existeChamadoAberto = rs.getInt(1);
                if (existeChamadoAberto == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return 0;
    }

    public void fechaConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
