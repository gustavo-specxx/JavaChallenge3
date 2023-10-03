package porto.com.br.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import porto.com.br.beans.Chamado;
import porto.com.br.dao.ChamadoDAO;

@Path("sinistro")
public class ChamadoController {
	
	private ChamadoDAO chamadoDAO;
	
	public ChamadoController(){
		
		chamadoDAO = new ChamadoDAO();
		
	}
	
	//, @PathParam("documentoSegurado") String documentoSegurado
	@POST
	public Response adicionarChamado(Chamado chamado ) {
		
		chamadoDAO.insereChamado(chamado, "45633416813");
		chamadoDAO.fechaConexao();
		
		return Response.status(Response.Status.CREATED).build();
	}


}
