package common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import org.apache.commons.lang3.builder.CompareToBuilder;

public class Song implements Comparable<Song> {

    private static final int COMPARETO_EQUAL = 0;
    private static final String UNKNOWN_GENRE = "UNKNOWN GENRE";
    private static final String DATE_FORMAT = "MM_dd_yyyy";
    private static final String KEY_SEP = "_";
    
    // The following are used for equalities and hash.  
    // The only questionable choice is dateProduced, and I've seen albumns
    // released more than once, with slightly different cuts, or added
    // "Bonus" extras.
    private String songName;	// Third Sort Key.
    private String albumnName;	// Secondary Sort Key
    private String artistName;	// Primary Sort Key
    private LocalDate dateProduced;

    // The following are not used for sort or equals or hash methods, and are not set by the constructor
    private String genre;

    public Song(String songName, String albumnName, String artistName, LocalDate dateProduced) {
	setSongName(songName);
	setAlbumnName(albumnName);
	setArtistName(artistName);
	setDateProduced(dateProduced);
	genre = UNKNOWN_GENRE;
    }

    public String getSongName() {
	return songName;
    }

    public void setSongName(String songName) {
	if (songName == null) {
	    throw new IllegalArgumentException("Illegal Song Name");
	}
	this.songName = songName;
    }

    public String getAlbumnName() {
	return albumnName;
    }

    public void setAlbumnName(String albumnName) {
	if (songName == null) {
	    throw new IllegalArgumentException("Illegal Albumn Name");
	}
	this.albumnName = albumnName;
    }

    public String getArtistName() {
	return artistName;
    }

    public void setArtistName(String artistName) {
	if (songName == null) {
	    throw new IllegalArgumentException("Illegal Artist Name");
	}
	this.artistName = artistName;
    }

    public LocalDate getDateProduced() {
	return dateProduced;
    }

    public void setDateProduced(LocalDate dateProduced) {
	if (dateProduced == null) {
	    throw new IllegalArgumentException("Illegal Date Produced");
	}
	this.dateProduced = dateProduced;
    }

    public String getGenre() {
	return genre;
    }

    public void setGenre(String genre) {
	if (genre == null) {
	    throw new IllegalArgumentException("Illegal Date Produced");
	}
	this.genre = genre;
    }

    /**
     * This method will generate a key string based upon the properties that are
     * used in the hashCode and equals methods.
     *
     * Presently that is the Artist, Albumn, Song, and Date Produced.. The
     * fields will be separated by '_'
     *
     * @return String containing generated key
     */
    public String getSongKey() {
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT);
	StringBuilder keyString = new StringBuilder(artistName);
	
	keyString.append(KEY_SEP);
	keyString.append(albumnName);
	keyString.append(KEY_SEP);
	keyString.append(songName);
	keyString.append(KEY_SEP);
	keyString.append(dateProduced.format(dateFormat));
	
	return keyString.toString();
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 29 * hash + Objects.hashCode(this.songName);
	hash = 29 * hash + Objects.hashCode(this.albumnName);
	hash = 29 * hash + Objects.hashCode(this.artistName);
	hash = 29 * hash + Objects.hashCode(this.dateProduced);
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final Song other = (Song) obj;
	if (!Objects.equals(this.songName, other.songName)) {
	    return false;
	}
	if (!Objects.equals(this.albumnName, other.albumnName)) {
	    return false;
	}
	if (!Objects.equals(this.artistName, other.artistName)) {
	    return false;
	}
	if (!Objects.equals(this.dateProduced, other.dateProduced)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Song{" + "songName=" + songName + ", albumnName=" + albumnName + ", artistName=" + artistName + ", dateProduced=" + dateProduced + '}';
    }

    @Override
    public int compareTo(Song song) {
	int retval = COMPARETO_EQUAL;

	retval = new CompareToBuilder()
		.append(this.artistName, song.getArtistName())
		.toComparison();
	if (retval == COMPARETO_EQUAL) {
	    retval = new CompareToBuilder()
		    .append(this.albumnName, song.getAlbumnName())
		    .toComparison();
	}
	if (retval == COMPARETO_EQUAL) {
	    retval = new CompareToBuilder()
		    .append(this.songName, song.getSongName())
		    .toComparison();
	}

	return retval;
    }
}
