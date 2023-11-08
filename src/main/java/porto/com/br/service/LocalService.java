package porto.com.br.service;

import porto.com.br.beans.Local;
import porto.com.br.infra.ViaCep.ViaCep;
import porto.com.br.infra.dao.LocalDAO;

public class LocalService {
    private LocalDAO localDAO;

    public LocalService() {
        localDAO = new LocalDAO();
    }

    public void insereLocal(Local local) {
        localDAO.insereLocal(local);
    }
    
    public Local localPorCep(String cep) {
    	
    	ViaCep viacep = new ViaCep();
    	
    	Local local = null;
    	
    	local = viacep.retornaLocalPesquisa(cep);
    	
    	return local;
    	
    }

    public void fechaConexao() {
    	
        localDAO.fechaConexao();
    }
}
