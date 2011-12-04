package project1;

import java.io.*;
import java.util.*;

import playlist.*;

public class ReversibleIteratorTester {

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("This project was written by Brandon Hawkins\n");

		// reading in a Playlist file to iterate through and grab Songs
		Scanner in = new Scanner(new File("pure-60s.txt"));
		Playlist pure = new Playlist("Pure60's");
		while (in.hasNextLine()) {
			String line = in.nextLine();
			int tab1 = line.indexOf('\t');
			int tab2 = line.indexOf('\t', tab1 + 1);
			int tab3 = line.indexOf('\t', tab2 + 1);
			if (tab1 >= 0 && tab2 >= 0 && tab3 >= 0) {
				String title = line.substring(0, tab1);
				String time = line.substring(tab1 + 1, tab2);
				String artist = line.substring(tab2 + 1, tab3);
				String album = line.substring(tab3 + 1);
				pure.add(new Song(title, artist, album, time));
			}
		}
		in.close();

		// pre-defined arrays, ArrayLists, and PublicLinkedLists - <String>,
		// <Integer>, & <Song>
		String[] s1 = { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th",
				"9th", "10th" };
		Integer[] i1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		ArrayList<String> s2 = new ArrayList(Arrays.asList(s1));
		ArrayList<Integer> i2 = new ArrayList(Arrays.asList(i1));

		PublicLinkedList<String> s3 = new PublicLinkedList<String>();
		for (int i = 0; i < s1.length; i++) {
			s3.addToEnd(s1[i]);
		}
		PublicLinkedList<Integer> i3 = new PublicLinkedList<Integer>();
		for (int i = 0; i < i1.length; i++) {
			i3.addToEnd(i1[i]);
		}

		// <Song> structures
		ArrayList<Song> songArrayList = pure.getList();
		Song[] songArray = new Song[songArrayList.size()];
		songArrayList.toArray(songArray);
		PublicLinkedList<Song> songLinkedList = new PublicLinkedList<Song>();
		for (int i = 0; i < songArray.length; i++) {
			songLinkedList.add(songArray[i]);
		}

		// Testing RIForArrayList
		System.out.println("Testing RIForArrayList with String test1:");
		RIForArrayList riforarraylistS1 = new RIForArrayList(s2);
		testerOne(riforarraylistS1);
		System.out.println();
		System.out.println("Testing RIForArrayList with String test2:");
		RIForArrayList riforarraylistS2 = new RIForArrayList(s2);
		testerTwo(riforarraylistS2);
		System.out.println();
		System.out.println("Testing RIForArrayList with Integer test1:");
		RIForArrayList riforarraylistI1 = new RIForArrayList(i2);
		testerOne(riforarraylistI1);
		System.out.println();
		System.out.println("Testing RIForArrayList with Integer test2:");
		RIForArrayList riforarraylistI2 = new RIForArrayList(i2);
		testerTwo(riforarraylistI2);
		System.out.println();
		System.out.println("Testing RIForArrayList with Song test1:");
		RIForArrayList riforarraylistSong1 = new RIForArrayList(songArrayList);
		testerOne(riforarraylistSong1);
		System.out.println();
		System.out.println("Testing RIForArrayList with Song test2:");
		RIForArrayList riforarraylistSong2 = new RIForArrayList(songArrayList);
		testerTwo(riforarraylistSong2);
		System.out.println();

		// Testing RIForArray
		System.out.println("Testing RIForArray with String test1:");
		RIForArray riforarrayS1 = new RIForArray(s1);
		testerOne(riforarrayS1);
		System.out.println();
		System.out.println("Testing RIForArray with String test2:");
		RIForArray riforarrayS2 = new RIForArray(s1);
		testerTwo(riforarrayS2);
		System.out.println();
		System.out.println("Testing RIForArray with Integer test1:");
		RIForArray riforarrayI1 = new RIForArray(i1);
		testerOne(riforarrayI1);
		System.out.println();
		System.out.println("Testing RIForArray with Integer test2:");
		RIForArray riforarrayI2 = new RIForArray(i1);
		testerTwo(riforarrayI2);
		System.out.println();
		System.out.println("Testing RIForArray with Song test1:");
		RIForArray riforarraySong1 = new RIForArray(songArray);
		testerOne(riforarraySong1);
		System.out.println();
		System.out.println("Testing RIFoArray with Song test2:");
		RIForArray riforarraySong2 = new RIForArray(songArray);
		testerTwo(riforarraySong2);
		System.out.println();

		// Testing RIForLinked List
		System.out.println("Testing RIForLinkedList with String test1");
		RIForLinkedList riforlinkedS1 = new RIForLinkedList(s3);
		testerOne(riforlinkedS1);
		System.out.println();
		System.out.println("Testing RIForLinkedList with String test2:");
		RIForLinkedList riforlinkedS2 = new RIForLinkedList(s3);
		testerTwo(riforlinkedS2);
		System.out.println();
		System.out.println("Testing RIForLinkedList with Integer test1:");
		RIForLinkedList riforlinkedI1 = new RIForLinkedList(i3);
		testerOne(riforlinkedI1);
		System.out.println();
		System.out.println("Testing RIForLinkedList with Integer test2:");
		RIForLinkedList riforlinkedI2 = new RIForLinkedList(i3);
		testerTwo(riforlinkedI2);
		System.out.println();
		System.out.println("Testing RIForLinkedList with Song test1");
		RIForLinkedList riforlinkedSong1 = new RIForLinkedList(songLinkedList);
		testerOne(riforlinkedSong1);
		System.out.println();
		System.out.println("Testing RIForLinkedList with Song test2");
		RIForLinkedList riforlinkedSong2 = new RIForLinkedList(songLinkedList);
		testerTwo(riforlinkedSong2);

		// Testing RIUsingArray
		System.out.println("Testing RIUsingArray with String test1:");
		RIForArray riforarrayS3 = new RIForArray(s1);
		ReversibleIterator<String> riusingarrayS1 = new RIUsingArray<String>(
				riforarrayS3);
		testerOne(riusingarrayS1);
		System.out.println();
		System.out.println("Testing RIUsingArray with String test2:");
		RIForArray riforarrayS4 = new RIForArray(s1);
		ReversibleIterator<String> riusingarrayS2 = new RIUsingArray<String>(
				riforarrayS4);
		testerTwo(riusingarrayS2);
		System.out.println();
		System.out.println("Testing RIUsingArray with Integer test1:");
		RIForArray riforarrayI3 = new RIForArray(i1);
		ReversibleIterator<Integer> riusingarrayI1 = new RIUsingArray<Integer>(
				riforarrayI3);
		testerOne(riusingarrayI1);
		System.out.println();
		System.out.println("Testing RIUsingArray with Integer test2:");
		RIForArray riforarrayI4 = new RIForArray(i1);
		ReversibleIterator<Integer> riusingarrayI2 = new RIUsingArray<Integer>(
				riforarrayI4);
		testerTwo(riusingarrayI2);
		System.out.println();
		System.out.println("Testing RIUsingArray with Song test1:");
		RIForArray riforarraySong3 = new RIForArray(songArray);
		ReversibleIterator<Song> riusingarraySong1 = new RIUsingArray<Song>(
				riforarraySong3);
		testerOne(riusingarraySong1);
		System.out.println();
		System.out.println("Testing RIUsingArray with Song test2:");
		RIForArray riforarraySong4 = new RIForArray(songArray);
		ReversibleIterator<Song> riusingarraySong2 = new RIUsingArray<Song>(
				riforarraySong4);
		testerTwo(riusingarraySong2);
		System.out.println();

		// Testing RIUsingArrayList
		System.out.println("Testing RIUsingArrayList with String test1:");
		RIForArrayList riforarraylistS3 = new RIForArrayList(s2);
		ReversibleIterator<String> riusingarraylistS1 = new RIUsingArrayList<String>(
				riforarraylistS3);
		testerOne(riusingarraylistS1);
		System.out.println();
		System.out.println("Testing RIUsingArrayList with String test2:");
		RIForArrayList riforarraylistS4 = new RIForArrayList(s2);
		ReversibleIterator<String> riusingarraylistS2 = new RIUsingArrayList<String>(
				riforarraylistS4);
		testerTwo(riusingarraylistS2);
		System.out.println();
		System.out.println("Testing RIUsingArrayList with Integer test1:");
		RIForArrayList riforarraylistI3 = new RIForArrayList(i2);
		ReversibleIterator<Integer> riusingarraylistI1 = new RIUsingArrayList<Integer>(
				riforarraylistI3);
		testerOne(riusingarraylistI1);
		System.out.println();
		System.out.println("Testing RIUsingArrayList with Integer test2:");
		RIForArrayList riforarraylistI4 = new RIForArrayList(i2);
		ReversibleIterator<Integer> riusingarraylistI2 = new RIUsingArrayList<Integer>(
				riforarraylistI4);
		testerTwo(riusingarraylistI2);
		System.out.println();
		System.out.println("Testing RIUsingArrayList with Song test1:");
		RIForArrayList riforarraylistSong3 = new RIForArrayList(songArrayList);
		ReversibleIterator<Song> riusingarraylistSong1 = new RIUsingArrayList<Song>(
				riforarraylistSong3);
		testerOne(riusingarraylistSong1);
		System.out.println();
		System.out.println("Testing RIUsingArrayList with Song test2:");
		RIForArrayList riforarraylistSong4 = new RIForArrayList(songArrayList);
		ReversibleIterator<Song> riusingarraylistSong2 = new RIUsingArrayList<Song>(
				riforarraylistSong4);
		testerTwo(riusingarraylistSong2);
		System.out.println();

		// Testing RIUsingLinkedList
		System.out.println("Testing RIUsingLinkedList with String test1:");
		RIForLinkedList riforlinkedS5 = new RIForLinkedList(s3);
		ReversibleIterator<String> riusinglinkedS1 = new RIUsingLinkedList<String>(
				riforlinkedS5);
		testerOne(riusinglinkedS1);
		System.out.println();
		System.out.println("Testing RIUsingLinkedList with String test2:");
		RIForLinkedList riforlinkedS6 = new RIForLinkedList(s3);
		ReversibleIterator<String> riusinglinkedS2 = new RIUsingLinkedList<String>(
				riforlinkedS6);
		testerTwo(riusinglinkedS2);
		System.out.println();
		System.out.println("Testing RIUsingLinkedList with Integer test1:");
		RIForLinkedList riforlinkedI5 = new RIForLinkedList(i3);
		ReversibleIterator<Integer> riusinglinkedI1 = new RIUsingLinkedList<Integer>(
				riforlinkedI5);
		testerOne(riusinglinkedI1);
		System.out.println();
		System.out.println("Testing RIUsingLinkedList with Integer test2:");
		RIForLinkedList riforlinkedI6 = new RIForLinkedList(i3);
		ReversibleIterator<Integer> riusinglinkedI2 = new RIUsingLinkedList<Integer>(
				riforlinkedI6);
		testerTwo(riusinglinkedI2);
		System.out.println();
		System.out.println("Testing RIUsingLinkedList with Song test1:");
		RIForLinkedList riforlinkedSong3 = new RIForLinkedList(songLinkedList);
		ReversibleIterator<Song> riusinglinkedSong1 = new RIUsingLinkedList<Song>(
				riforlinkedSong3);
		testerOne(riusinglinkedSong1);
		System.out.println();
		System.out.println("Testing RIUsingLinkedList with Song test2:");
		RIForLinkedList riforlinkedSong4 = new RIForLinkedList(songLinkedList);
		ReversibleIterator<Song> riusinglinkedSong2 = new RIUsingLinkedList<Song>(
				riforlinkedSong4);
		testerTwo(riusinglinkedSong2);
		System.out.println();

	}

	// go forward from the 1st element to last, go backward to 1st, and then
	// foward to last again
	public static <T> void testerOne(ReversibleIterator<T> iter) {
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		while (iter.hasPrevious()) {
			System.out.println(iter.previous());
		}
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	// go foward from 1st to 5th, back three, and then forward to the end
	public static <T> void testerTwo(ReversibleIterator<T> iter) {
		for (int i = 0; i < 5; i++) {
			System.out.println(iter.next());
		}
		for (int j = 0; j < 3; j++) {
			System.out.println(iter.previous());
		}
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}