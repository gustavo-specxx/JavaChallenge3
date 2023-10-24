package porto.com.br.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import porto.com.br.beans.Local;
import porto.com.br.service.LocalService;

@Path("local")
public class LocalController {
    private LocalService localService;

    public LocalController() {
        localService = new LocalService();
    }

    @POST
    public Response adicionaLocalSinistro(Local local) {
        localService.insereLocal(local);
        localService.fechaConexao();
        return Response.status(Response.Status.CREATED).build();
    }
}
