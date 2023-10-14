package porto.com.br.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import porto.com.br.beans.Apolice;
import porto.com.br.dao.ApoliceDAO;

@Path("apolice")
public class ApoliceController {
	
	private ApoliceDAO apoliceDao;
	private Status status;
	
	@GET
	@Path("/{DOCUMENTO_SEGURADO}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retornaApolice(@PathParam("DOCUMENTO_SEGURADO") 
									String DOCUMENTO_SEGURADO) {
		
		ArrayList<Apolice> apolices = new ArrayList<>();
		
		apoliceDao = new ApoliceDAO();
		
		apolices = apoliceDao.retornaApoliceSegurado(DOCUMENTO_SEGURADO);
		
		if (apolices.isEmpty()) status = Response.Status.NOT_FOUND;
		else status = Response.Status.FOUND;
		
		
		return Response.status(status).entity(apolices).build();
	}
}
