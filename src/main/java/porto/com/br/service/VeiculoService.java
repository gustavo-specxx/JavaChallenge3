package porto.com.br.service;

import porto.com.br.beans.Veiculo;
import porto.com.br.infra.dao.VeiculoDAO;

public class VeiculoService {
    private VeiculoDAO veiculoDAO;

    public VeiculoService() {
        veiculoDAO = new VeiculoDAO();
    }

    public Veiculo selecionaVeiculoPelaPlaca(String documentoSegurado, String placaVeiculo) {
        return veiculoDAO.selecionaVeiculoPelaPlaca(documentoSegurado, placaVeiculo);
    }

    public void fechaConexao() {
        veiculoDAO.fechaConexao();
    }
}
