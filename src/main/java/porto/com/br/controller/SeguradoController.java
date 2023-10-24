package porto.com.br.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import porto.com.br.beans.Segurado;
import porto.com.br.service.SeguradoService;
import javax.ws.rs.core.MediaType;

@Path("segurado")
public class SeguradoController {
    private SeguradoService seguradoService;

    public SeguradoController() {
        seguradoService = new SeguradoService();
    }

    @GET
    @Path("/{DOCUMENTO_SEGURADO}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaSeguradoCPF(@PathParam("DOCUMENTO_SEGURADO") String DOCUMENTO_SEGURADO) {
        Response.Status status = null;

        Segurado segurado = seguradoService.retornaSegurado(DOCUMENTO_SEGURADO);

        if (segurado == null) {
            status = Response.Status.NOT_FOUND;
        } else {
            status = Response.Status.OK;
        }

        return Response.status(status).entity(segurado).build();
    }
}
