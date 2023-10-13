package porto.com.br.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import porto.com.br.beans.Segurado;
import porto.com.br.dao.SeguradoDAO;

@Path("segurado")
public class SeguradoController {
	
	SeguradoDAO seguradoDAO= new SeguradoDAO();
	
	@GET
	@Path("/{DOCUMENTO_SEGURADO}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retornaSeguradoCPF(
			@PathParam("DOCUMENTO_SEGURADO") String DOCUMENTO_SEGURADO
			) {
		
		Response.Status status = null;
		
	
		Segurado segurado = seguradoDAO.retornaSegurado(DOCUMENTO_SEGURADO);

		if(segurado == null)  status = Response.Status.NOT_FOUND;
		else status = Response.Status.OK;
			
		return Response.status(status).entity(segurado).build();
		
	}
		
}
