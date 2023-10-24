package porto.com.br.service;

import porto.com.br.beans.Apolice;
import porto.com.br.dao.ApoliceDAO;

import java.util.ArrayList;

public class ApoliceService {
    private ApoliceDAO apoliceDAO;

    public ApoliceService() {
        apoliceDAO = new ApoliceDAO();
    }

    public ArrayList<Apolice> retornaApoliceSegurado(String documentoSegurado) {
        return apoliceDAO.retornaApoliceSegurado(documentoSegurado);
    }

    public int retornaIdApolice(int indexApolice, String documentoSegurado) {
        return apoliceDAO.retornaIdApolice(indexApolice, documentoSegurado);
    }

    public void fechaConexao() {
        apoliceDAO.fechaConexao();
    }
}
