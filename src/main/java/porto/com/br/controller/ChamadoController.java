package porto.com.br.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import porto.com.br.beans.Chamado;
import porto.com.br.service.ChamadoService;

@Path("sinistro")
public class ChamadoController {
    private ChamadoService chamadoService;

    public ChamadoController() {
        chamadoService = new ChamadoService();
    }

    @POST
    public Response adicionarChamado(Chamado chamado, @PathParam("idLocalSinistro") int idLocalSinistro,
                                      @PathParam("idApoliceSeguro") int idApoliceSeguro,
                                      @PathParam("documentoSegurado") String documentoSegurado) {
        chamadoService.insereChamado(chamado, documentoSegurado, idLocalSinistro, idApoliceSeguro);
        chamadoService.fechaConexao();
        return Response.status(Response.Status.CREATED).build();
    }
}
