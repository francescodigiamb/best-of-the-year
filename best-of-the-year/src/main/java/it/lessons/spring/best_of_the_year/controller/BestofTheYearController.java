package it.lessons.spring.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.lessons.spring.best_of_the_year.model.Movie;
import it.lessons.spring.best_of_the_year.model.Song;

@Controller
@RequestMapping ("/")
public class BestofTheYearController {

	@GetMapping ("/home") 
	public String home (@RequestParam(name = "name", required = false) String name, Model model) {
		
	        // Aggiungi il nome come attributo nel Model
	        model.addAttribute("name", name);

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
    public String showMovies(@RequestParam(name = "name", required = false) String name, Model model) {
        List<Movie> movies = getBestMovies();
        StringBuilder titles = new StringBuilder();

        for (Movie movie : movies) {
            if (titles.length() > 0) {
                titles.append(", ");
            }
            titles.append(movie.getTitolo());
        }
        model.addAttribute("name", name);
        model.addAttribute("titles", titles.toString());
        
        return "movies";
    }
    
    @GetMapping("/songs") 
    public String showSongs(@RequestParam(name = "name", required = false) String name, Model model) {
        List<Song> songs = getBestSongs();
        StringBuilder titles = new StringBuilder();

        for (Song song : songs) {
            if (titles.length() > 0) {
                titles.append(", ");
            }
            titles.append(song.getTitolo());
        }
        model.addAttribute("name", name);
        model.addAttribute("titles", titles.toString());
        
        return "movies";
    }
    
}
