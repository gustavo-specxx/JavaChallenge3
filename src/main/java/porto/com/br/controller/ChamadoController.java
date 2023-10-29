package porto.com.br.controller;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import porto.com.br.beans.Chamado;
import porto.com.br.service.ChamadoService;

@Path("chamado")
public class ChamadoController {
    private ChamadoService chamadoService;

    public ChamadoController() {
        chamadoService = new ChamadoService();
    }

    @POST
    public Response adicionarChamado(Chamado chamado, @PathParam("idLocalSinistro") int idLocalSinistro,
                                      @PathParam("idApoliceSeguro") int idApoliceSeguro,
                                      @PathParam("documentoSegurado") String documentoSegurado) {
        
    	
    	try {
    	chamadoService.insereChamado(chamado/*, documentoSegurado, idLocalSinistro, idApoliceSeguro*/);
    	return Response.status(Response.Status.CREATED).build();

    	}catch(RuntimeException e) {
    		System.out.println(e.getMessage());
    		e.printStackTrace();
    		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    	}
    	

        
       // chamadoService.fechaConexao();
    }
    
    
    @GET
    @Path("/{DOCUMENTO_SEGURADO}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaChamadosPorSegurado(@PathParam("DOCUMENTO_SEGURADO") String DOCUMENTO_SEGURADO) {
        Response.Status status = null;

        ArrayList<Chamado> chamados = chamadoService.retornaChamados(DOCUMENTO_SEGURADO);

        if (chamados.isEmpty()) {
            status = Response.Status.NOT_FOUND;
        } else {
            status = Response.Status.OK;
        }

        return Response.status(status).entity(chamados).build();
    }
   }
