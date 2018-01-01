package artist.service;

import java.util.List;

import artist.entity.Artist;

public interface ArtistService {

	
	 public List<Artist> getArtists();

	public void saveArtist(Artist theArtist);

	public Artist getArtist(int theId);

	public void deleteArtist(int theId);
}
