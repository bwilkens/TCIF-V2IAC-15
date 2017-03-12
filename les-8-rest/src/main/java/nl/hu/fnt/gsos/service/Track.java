package nl.hu.fnt.gsos.service;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Track {
	int id;
	String artist;
	String song;
	int year;
	String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", artist=" + artist + ", song=" + song
				+ "]";
	}

	public Track() {
		super();
	}

	public Track(int id, String artist, String song, int year, String url) {
		super();
		this.id = id;
		this.artist = artist;
		this.song = song;
		this.year = year;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
