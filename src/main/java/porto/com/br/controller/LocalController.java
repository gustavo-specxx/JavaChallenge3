package porto.com.br.controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
    	
    	try {
	        localService.insereLocal(local);
	        localService.fechaConexao();
	        return Response.status(Response.Status.CREATED).build();
        
       	}catch(RuntimeException e) {
    		System.out.println(e.getMessage());
    		e.printStackTrace();
    		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    	}
    }
    
    
    @GET
    @Path("/{CEP}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaLocalPesquisa(@PathParam("CEP") String cep) {
    	
    	Status status = null;
    	Local local = null;
    	
    	local = localService.localPorCep(cep);
    	
    	if(local.getEndLocalSinistro() == null) {
    		status = Response.Status.NOT_FOUND;
    	} else {
    		status = Response.Status.OK;
    		
    	}
    	
    	return Response.status(status).entity(local).build();
    	
    	
    
    }
}
