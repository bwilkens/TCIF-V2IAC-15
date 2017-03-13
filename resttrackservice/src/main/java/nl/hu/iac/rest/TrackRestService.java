package nl.hu.iac.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.hu.iac.service.ServiceProvider;
import nl.hu.iac.service.Track;
import nl.hu.iac.service.TrackServiceImpl;

@Path("/tracks")
public class TrackRestService {
	
	@GET
	@Path("/{trackId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Track getTrack(@PathParam("trackId") int trackId) {
		TrackServiceImpl trackServiceImpl = ServiceProvider.getTrackService();
		return trackServiceImpl.getTrackById(trackId);
	}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Track> getAllTracks() {
		TrackServiceImpl trackServiceImpl = ServiceProvider.getTrackService();
		return trackServiceImpl.getTracks();
	}
	
	@PUT
	@Consumes ({MediaType.APPLICATION_JSON})
	@Produces ({MediaType.APPLICATION_JSON})
	public Track createUser(Track track){
		TrackServiceImpl trackServiceImpl = ServiceProvider.getTrackService();
		return trackServiceImpl.add(track);

	}





}
