package artist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import artist.entity.Artist;
import artist.service.ArtistService;


@Controller
@RequestMapping("/artist")
public class ArtistController {
	
	// inject ArtistService
	@Autowired
	private ArtistService artistService;
	

	  @GetMapping("/list")
	  public String listArtist (Model theModel) {
		  
		  // get artist from the service
		  List<Artist> theArtist = artistService.getArtists();
		  
		  // add the artsits to the model
		  theModel.addAttribute("artists", theArtist);
		  
		  
		  return "list-artist";
	  }

	  @GetMapping("/showFormForAdd")
	  public String showFormForAdd(Model theModel) {
		  
		  // create model attribute to bind form data 
		  Artist theArtist = new Artist();
		  
		  theModel.addAttribute("artist", theArtist);
		  
		  return "artist-form";
	  }
	  
	  @PostMapping("/saveArtist")
	  public String saveArtist(@ModelAttribute("artist") Artist theArtist ) {
		  
		  // save the artist using service
		  artistService.saveArtist(theArtist);
		  
		  return "redirect:/artist/list";
	  }
	  
	  @GetMapping("/showFormForUpdate")
	  public String showFormForUpdate(@RequestParam("artistId") int theId,
			                                               Model theModel) {
		
		  // get the artist from the database
		  Artist theArtist = artistService.getArtist(theId);
		  
		  // set artist as a model attribute to pre-populate the form
		  theModel.addAttribute("artist", theArtist);
		  
		  // send over to our form
		  return "artist-form";
	
	  }
	  @GetMapping("/delete")
		public String deleteArtist(@RequestParam("artistId") int theId, Model theModel) {
			
		 artistService.deleteArtist(theId);
			
			return "redirect:/artist/list";
			
		}
	  
}
