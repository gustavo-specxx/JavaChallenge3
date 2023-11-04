package porto.com.br.service;

import porto.com.br.beans.Local;
import porto.com.br.infra.dao.LocalDAO;

public class LocalService {
    private LocalDAO localDAO;

    public LocalService() {
        localDAO = new LocalDAO();
    }

    public void insereLocal(Local local) {
        localDAO.insereLocal(local);
    }

    public void fechaConexao() {
        localDAO.fechaConexao();
    }
}
