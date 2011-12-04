package playlist;

//Album is-a Playlist
public class Album extends Playlist {
	//Album has an artist and an album (in addition to superclass variables)
	private String artist, album;

	// constructor initializes private variables and calls superclass
	// constructor
	public Album(String artist, String album) {

		super(album + " by " + artist);
		this.artist = artist;
		this.album = album;
	}

	public String getArtist() {
		return artist;
	}

	public String getAlbum() {
		return album;
	}

	// only add if same artist and album
	public boolean add(Song song) {
		if (artist.equals(song.getArtist()) && album.equals(song.getAlbum())) {
			return super.add(song);
		} else {
			return false;
		}
	}

}
