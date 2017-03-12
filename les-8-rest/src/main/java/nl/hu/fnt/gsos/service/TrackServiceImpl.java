package nl.hu.fnt.gsos.service;

import java.util.ArrayList;
import java.util.List;

public class TrackServiceImpl {
	private List<Track> tracks = new ArrayList<Track>();

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public TrackServiceImpl() {
		tracks.add(new Track(1, "The Doors", "Light My Fire", 1967,
				"www.youtube.com/watch?v=M_yWyBjDEaU"));
		tracks.add(new Track(2, "Rolling Stones", "Angie", 1974,
				"www.youtube.com/watch?v=RcZn2-bGXqQ"));
		tracks.add(new Track(3, "Kraftwerk", "The model", 1978,
				"www.youtube.com/watch?v=BdZDhpkDziE"));
		tracks.add(new Track(4, "Pixies", "Monkey Gone to Heaven", 1989,
				"www.youtube.com/watch?v=mK3iSglbZUM"));
		tracks.add(new Track(5, "St germain", "Rose Rouge", 2000,
				"https://www.youtube.com/watch?v=yRpKKBmeqV4"));
		tracks.add(new Track(6, "Lilly Wood & The Prick",
				"Prayer In C (Robin Schulz Remix)", 2014,
				"https://www.youtube.com/watch?v=fiore9Z5iUg"));
	}

	public Track getTrackById(int id) {
		for (Track track : tracks) {
			if (track.getId() == id) {
				return track;
			}
		}
		return null;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public boolean remove(int id) {
		return tracks.remove(findTrack(id));
	}

	private Track findTrack(int id) {
		for (Track track: tracks) {
			if (track.getId()==id) {
				return track;
			}
				
		}
		return null;
	}

}
