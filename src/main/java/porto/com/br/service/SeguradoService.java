package porto.com.br.service;

import porto.com.br.beans.Segurado;
import porto.com.br.dao.SeguradoDAO;

public class SeguradoService {
    private SeguradoDAO seguradoDAO;

    public SeguradoService() {
        seguradoDAO = new SeguradoDAO();
    }

    public int retornaIdSegurado(String documentoSegurado) {
        return seguradoDAO.retornaIdSegurado(documentoSegurado);
    }

    public Segurado retornaSegurado(String documentoSegurado) {
        return seguradoDAO.retornaSegurado(documentoSegurado);
    }

    public void fechaConexao() {
        seguradoDAO.fechaConexao();
    }
}
