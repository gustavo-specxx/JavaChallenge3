package porto.com.br.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import porto.com.br.beans.Local;
import porto.com.br.dao.LocalDAO;

@Path("local")
public class LocalController {
	
	LocalDAO localDao = new LocalDAO();
	
	@POST
	public Response adicionaLocalSinistro(Local local) {
		
		//localDao.insereLocal(local);
		//localDao.fechaConexao();
		return Response.status(Response.Status.CREATED).build();
		
	}

}
