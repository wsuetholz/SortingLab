/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Comparator;
import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 *
 * @author wsuetholz
 */
public class SongByArtist implements Comparator<Song> {

    @Override
    public int compare(Song o1, Song o2) {
	return new CompareToBuilder()
		.append(o1.getArtistName(), o2.getArtistName())
		.toComparison();

    }

}
