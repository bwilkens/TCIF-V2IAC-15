package nl.hu.fnt.gsos.service;


public class ServiceProvider {
	private static TrackServiceImpl trackService = new TrackServiceImpl();
	public static TrackServiceImpl getTrackService() {
		return trackService;
	}
}