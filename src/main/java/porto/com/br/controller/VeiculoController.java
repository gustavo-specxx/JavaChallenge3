package porto.com.br.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import porto.com.br.beans.Veiculo;
import porto.com.br.dao.VeiculoDAO;

@Path("veiculo")
public class VeiculoController {
	
	VeiculoDAO veiculoDAO= new VeiculoDAO();
	
	@GET
	@Path("/{DOCUMENTO_SEGURADO}/{PLACA_VEICULO}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retornaVeiculoPelaPlaca(
			@PathParam("DOCUMENTO_SEGURADO") String DOCUMENTO_SEGURADO
			,@PathParam("PLACA_VEICULO") String PLACA_VEICULO
			) {
		
		Response.Status status = null;
		
	
		Veiculo veiculo = veiculoDAO.selecionaVeiculoPelaPlaca(DOCUMENTO_SEGURADO, PLACA_VEICULO);

		if(veiculo == null)  status = Response.Status.NOT_FOUND;
		else status = Response.Status.OK;
			
		return Response.status(status).entity(veiculo).build();
		
	}
		
}
