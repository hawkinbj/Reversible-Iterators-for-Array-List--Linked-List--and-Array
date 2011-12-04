package playlist;

import java.util.*;

//Playlist has-an association with Song, ArrayList, and Iterable 
public class Playlist implements Iterable<Song> {
	//Playlist has an ArrayList of Songs and a title
	private ArrayList<Song> list;
	private String title;

	//constructor initializes instance variables
	public Playlist(String title) {
		this.title = title;
		setList(new ArrayList<Song>());
	}

	public String getTitle() {
		return title;
	}
	
	//returns the size of the list
	public int size() {
		return getList().size();
	}
	
	//tests if the playlist contains a certain song
	public boolean contains(Song test) {
		return getList().contains(test);
	}

	//creates an iterator to move through the list
	public Iterator<Song> iterator() {
		return getList().iterator();
	}
	
	//adds a song to the list
	public boolean add(Song song) {
		getList().add(song);
		return true;
	}
	
	//toString
	public String toString() {

		String toReturn = getClass() + ": " + title + "\n";
		for (int k = 0; k < getList().size(); k++) {
			toReturn += "Title: " + getList().get(k).getName() + " by "
					+ getList().get(k).getArtist() + " on " + getList().get(k).getAlbum()
					+ ", time: " + getList().get(k).getTime() + "\n";
		}
		toReturn += getList().size() + " songs";
		return toReturn;
	}

	public void setList(ArrayList<Song> list) {
		this.list = list;
	}

	public ArrayList<Song> getList() {
		return list;
	}

}
