package it.lessons.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping 
public class HomeController {

	@GetMapping ("/") 
	public String home (Model model) {
		
	        // Aggiungi il nome come attributo nel Model
	        model.addAttribute("name", "Francesco");

	        // Restituisci il nome della vista Thymeleaf da renderizzare
	        return "home";
	}
	
    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Scarface"));
        movies.add(new Movie(2, "Avengers-End Game"));
        movies.add(new Movie(3, "Batman-The Dark Knight"));
        movies.add(new Movie(4, "Inception"));
        movies.add(new Movie(5, "Interstellar"));
        
        return movies;
    }
	
    private List<Song> getBestSongs() {
    	List<Song> songs = new ArrayList<>();
    	songs.add(new Song(1, "Crudelia"));
    	songs.add(new Song(2, "L'alba"));
    	songs.add(new Song(3, "Il cielo in una stanza"));
    	songs.add(new Song(4, "Le luci della città"));
    	
    	return songs;
    }
    
    @GetMapping("/movies")
    public String showMovies(Model model) {
        List<String> movieTitles = getBestMovies().stream()
                .map(Movie::getTitolo)
                .collect(Collectors.toList());
        model.addAttribute("titles", String.join(", ", movieTitles));
        return "movies";
    }
    
    @GetMapping("/songs")
    public String showSongs(Model model) {
        List<String> songTitles = getBestSongs().stream()
                .map(Song::getTitolo)
                .collect(Collectors.toList());
        model.addAttribute("titles", String.join(", ", songTitles));
        return "songs";
    }

}
