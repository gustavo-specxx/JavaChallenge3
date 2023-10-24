package porto.com.br.service;

import porto.com.br.beans.Chamado;
import porto.com.br.dao.ChamadoDAO;

import java.util.ArrayList;

public class ChamadoService {
    private ChamadoDAO chamadoDAO;

    public ChamadoService() {
        chamadoDAO = new ChamadoDAO();
    }

    public void insereChamado(Chamado chamado, String documentoSegurado, int idApolice, int idLocalSinistro) {
        chamadoDAO.insereChamado(chamado, documentoSegurado, idApolice, idLocalSinistro);
    }

    public int validaChamado(String documentoSegurado) {
        return chamadoDAO.validaChamado(documentoSegurado);
    }

    public ArrayList<Chamado> retornaChamados(String documentoSegurado) {
        return chamadoDAO.retornaChamados(documentoSegurado);
    }

    public void fechaConexao() {
        chamadoDAO.fechaConexao();
    }
}
