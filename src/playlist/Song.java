package playlist;

//Song class is associated with Playlist class and has-a Comparable method
public class Song implements Comparable<Song> {
	// A Song in Lab has a name, artist, album, and time.
	private String name, artist, album, time;

	// Song constructor, can't be null
	public Song(String name, String artist, String album, String time) {
		if (name == null)
			throw new RuntimeException("name can't be null");

		this.name = name;
		this.artist = artist;
		this.album = album;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public String getArtist() {
		return artist;
	}

	public String getAlbum() {
		return album;
	}

	public String getTime() {
		return time;
	}

	// tests whether this song object is equal to another - checks to make sure
	// tested object is indeed a song
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof Song) {
			Song other = (Song) obj;
			return name.equals(other.name) && artist.equals(other.artist)
					&& album.equals(other.album) && time.equals(other.time);
		} else
			return false;
	}

	// Comparable implementation
	@Override
	public int compareTo(Song other) {
		if (other == null) {
			throw new NullPointerException("null argument as paramater");
		}
		// May need to compare this to all the attributes and not just name!!
		Song song = (Song) other;
		return this.getName().compareTo(song.getName());
	}

	public String toString() {
		return "Name: " + name + "\nArtist: " + artist + "\nAlbum: " + album
				+ "\nTime: " + time;
	}
}