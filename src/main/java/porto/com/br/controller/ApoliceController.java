package porto.com.br.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import porto.com.br.beans.Apolice;
import porto.com.br.service.ApoliceService;

import java.util.ArrayList;

@Path("apolice")
public class ApoliceController {
    private ApoliceService apoliceService;

    public ApoliceController() {
        apoliceService = new ApoliceService();
    }

    @GET
    @Path("/{DOCUMENTO_SEGURADO}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaApolice(@PathParam("DOCUMENTO_SEGURADO") String DOCUMENTO_SEGURADO) {
        Response.Status status = null;

        ArrayList<Apolice> apolices = apoliceService.retornaApoliceSegurado(DOCUMENTO_SEGURADO);

        if (apolices.isEmpty()) {
            status = Response.Status.NOT_FOUND;
        } else {
            status = Response.Status.OK;
        }

        return Response.status(status).entity(apolices).build();
    }
}
//att