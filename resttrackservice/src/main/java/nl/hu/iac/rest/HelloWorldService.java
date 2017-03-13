package nl.hu.iac.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
 
@Path("/hello")
public class HelloWorldService {
 
	@GET
	public Response getMessage() {
 
		String output = "Berend says: hello";
 
		return Response.status(200).entity(output).build();
 
	}
 

	@GET
	@Path("/{name}")
	public Response getMsg(@PathParam("name") String name) {
 
		String output = "Jersey say : hello "+name;
 
		return Response.status(200).entity(output).build();
 
	}
 
}