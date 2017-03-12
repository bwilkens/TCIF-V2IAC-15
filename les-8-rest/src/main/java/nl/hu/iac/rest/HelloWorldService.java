package nl.hu.iac.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
 
@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("/hello")
	public Response getMsg() {
 
		String output = "Jersey say : hello";
 
		return Response.status(200).entity(output).build();
 
	}
 
}