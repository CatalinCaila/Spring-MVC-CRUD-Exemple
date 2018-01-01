package artist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import artist.dao.ArtistDAO;
import artist.entity.Artist;

@Service
public class ArtistServiceImpl implements ArtistService {

	@Autowired
	private ArtistDAO artistDAO;
	
	@Override
	@Transactional
	public List<Artist> getArtists() {
		
		return  artistDAO.getArtists();
	}

	@Override
	@Transactional
	public void saveArtist(Artist theArtist) {
		
		artistDAO.saveArtist(theArtist);
		
	}

	@Override
	@Transactional
	public Artist getArtist(int theId) {
		
		return artistDAO.getArtist(theId);
	}

	@Override
	@Transactional
	
	public void deleteArtist(int theId) {
		
	 artistDAO.deleteArtist(theId);
		
	}

}
