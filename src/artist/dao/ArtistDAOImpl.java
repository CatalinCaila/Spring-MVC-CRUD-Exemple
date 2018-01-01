package artist.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import artist.entity.Artist;

@Repository
public class ArtistDAOImpl implements ArtistDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Artist> getArtists() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ...sort by year
		Query<Artist> theQuery =
				currentSession.createQuery("from Artist order by year",
						Artist.class);
		
		// execute query get result list
		List<Artist> artists = theQuery.getResultList();
		
		// return the result 
		return artists;
	}


	@Override
	public void saveArtist(Artist theArtist) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the artist
		currentSession.saveOrUpdate(theArtist);
	}


	@Override
	public Artist getArtist(int theId) {
		
		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrive/read form database  using the primary key
		Artist theArtist = currentSession.get(Artist.class, theId);
		
		return theArtist;
	}


	@Override
	public void deleteArtist(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery= currentSession.createQuery("delete from Artist where id=:artistId");
		theQuery.setParameter("artistId",theId);
		
		theQuery.executeUpdate();
	}

}
