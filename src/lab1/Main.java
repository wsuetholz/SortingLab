/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import common.Song;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author wsuetholz
 */
public class Main {
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    
    public static void printSet(String listName, Set<Song> mySet) {
	if (listName == null || mySet == null) {
	    throw new IllegalArgumentException("Cannot be NULL!");
	}
	
	printList (listName, new ArrayList<Song>(mySet));
    }
	
    public static void printList(String listName, List<Song> myList) {
	if (listName == null || myList == null) {
	    throw new IllegalArgumentException("Cannot be NULL!");
	}
	
	int i = 0;
	for (Song song : myList) {
	    System.out.println(listName + "[" + i + "] to String is \"" + song.toString() + "\".");
	    i++;
	}	
    }

    public static void printMap(String mapName, Map<String,Song> myMap) {
	if (mapName == null || myMap == null) {
	    throw new IllegalArgumentException("Cannot be NULL!");
	}
	
	int i = 0;
	for (Song song : myMap.values()) {
	    System.out.println(mapName + "[" + i + "] to String is \"" + song.toString() + "\".");
	    i++;
	}	
	i = 0;
	for (String key : myMap.keySet()) {
	    System.out.println(mapName + "[" + i + "] key String is \"" + key + "\".");
	    i++;
	}	
    }

    public static void main(String[] args) {
	Song song ;
	Set<Song> songs = new TreeSet<>();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT);

	song = new Song ( "Another Girl", "Help!", "Beatles", LocalDate.parse("01/01/1965", dateFormat));
	songs.add(song);
	song = new Song ( "Baby It's You", "Please Please Me", "Beatles", LocalDate.parse("01/01/1963", dateFormat));
	songs.add(song);
	song = new Song ( "Witchy Woman", "Eagles", "Eagles", LocalDate.parse("01/01/1972", dateFormat));
	songs.add(song);
	song = new Song ( "Ask Me Why", "Please Please Me", "Beatles", LocalDate.parse("01/01/1963", dateFormat));
	songs.add(song);
	song = new Song ( "Baby, You're a Rich Man", "Magical Mystery Tour", "Beatles", LocalDate.parse("01/01/1967", dateFormat));
	songs.add(song);
	song = new Song ( "Desperado", "Desperado", "Eagles", LocalDate.parse("01/01/1973", dateFormat));
	songs.add(song);
	song = new Song ( "Another Girl", "Help!", "Beatles", LocalDate.parse("01/01/1965", dateFormat));
	songs.add(song);
	song = new Song ( "Act Naturally", "Help!", "Beatles", LocalDate.parse("01/01/1965", dateFormat));
	songs.add(song);
	song = new Song ( "Take It Easy", "Eagles", "Eagles", LocalDate.parse("01/01/1972", dateFormat));
	songs.add(song);
	song = new Song ( "Tequila Sunrise", "Desperado", "Eagles", LocalDate.parse("01/01/1973", dateFormat));
	songs.add(song);
	
	printSet ("songSet", songs);

    }
}
