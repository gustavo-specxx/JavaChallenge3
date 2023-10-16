package porto.com.br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import porto.com.br.beans.Chamado;


public class ChamadoDAO {
    Connection conn = new ConnectionFactory().criaConexao();
    
    public void insereChamado(Chamado chamado, String documentoSegurado, int id_apolice_seguro, int id_local_sinistro) {
        String sql = "insert into TB_PSG_ORDEM_SERVICO (ID_ORDEM_SERVICO"
+ "                                 ,TIPO_SINISTRO"
+ "                                 ,DATA_SINISTRO"
+ "                                 ,ID_SEGURADO"
+ "                                 ,DESCRICAO_SINISTRO"
+ "                                 ,ID_APOLICE_SEGURO"
+ "                                 ,ID_LOCAL_SINISTRO)"
+ "                                 VALUES(seq_id_ordem_servico.nextval,?,?,?,?,?,?)";
    	SeguradoDAO seguradoDAO =  new SeguradoDAO();

        try (//Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
    
        	
        	String desc_chamado = (chamado.getDescricaoChamado()!= null) ? chamado.getDescricaoChamado() : "CHAMADO";
        	
        	 java.util.Date dataAtual = new java.util.Date();
        	 java.sql.Date  dataInsert = new java.sql.Date(dataAtual.getTime());
        	
            pstmt.setInt(1, chamado.getTipoSinistro());
            pstmt.setDate(2, dataInsert); //data
            pstmt.setInt(3,seguradoDAO.retornaIdSegurado(documentoSegurado));
            pstmt.setString(4, desc_chamado); 
            pstmt.setInt(5, id_apolice_seguro);
            pstmt.setInt(6, id_local_sinistro);
            
        	
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
        String sqlSelect = "SELECT COUNT(1) FROM tb_psg_ordem_servico WHERE ID_SEGURADO = ? AND STATUS_OS != 'E'";
        int existeChamadoAberto;

        try {
        	
        	SeguradoDAO seg = new SeguradoDAO();
        	int idSegurado = seg.retornaIdSegurado(documentoSegurado);
        	
            PreparedStatement query = conn.prepareStatement(sqlSelect);
            query.setInt(1, idSegurado);
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
