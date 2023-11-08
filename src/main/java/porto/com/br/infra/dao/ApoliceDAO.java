package porto.com.br.infra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import porto.com.br.beans.Apolice;
import porto.com.br.beans.Chamado;


public class ApoliceDAO {
    Connection conn = new ConnectionFactory().criaConexao();
    
    public ArrayList<Apolice> retornaApoliceSegurado(String doctoSegurado) {
        ArrayList<Apolice> apolices = new ArrayList<>();

        String sqlSelect = "select case when tipo_apolice_seguro = 'I' THEN 'Individual' "
                + "            when tipo_apolice_seguro = 'C' THEN 'Coletiva' "
                + "              end tipo_apolice "
                + "        ,  cod_apolice_seguro "
                + "        ,  cobertura_apolice "
                + "        ,  id_apolice_seguro "
                + "        from tb_psg_apolice_seguro apol "
                + "        ,    tb_psg_segurado segu "
                + "        where apol.id_segurado = segu.id_segurado "
                + "        and   segu.documento_segurado = ? "
                + "        and   apolice_ativa = 1"; 

        try {
            PreparedStatement selectApolice = conn.prepareStatement(sqlSelect);
            selectApolice.setString(1, doctoSegurado);
            ResultSet rs = selectApolice.executeQuery();
          

            while (rs.next()) {
                Apolice apolice = new Apolice();
                apolice.setCodApolice(rs.getString("COD_APOLICE_SEGURO"));
                apolice.setTipoApolice(rs.getString("TIPO_APOLICE"));
                apolice.setCoberturaApolice(rs.getString("COBERTURA_APOLICE"));
                apolice.setIdApolice(rs.getInt("ID_APOLICE_SEGURO"));

                
                apolices.add(apolice);
            }

            selectApolice.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        
        return apolices;
    }
    
    public int retornaIdApolice(int indexApolice, String documentoSegurado) {
    	
    	ArrayList<Apolice> apolices = retornaApoliceSegurado(documentoSegurado);
    	
    	int idApolice = apolices.get(indexApolice).getIdApolice();
    	          
       return idApolice;
    }

    
   

    public void fechaConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
