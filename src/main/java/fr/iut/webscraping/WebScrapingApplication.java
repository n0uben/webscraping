package fr.iut.webscraping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class WebScrapingApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebScrapingApplication.class, args);

		ArrayList<Movie> listOfMovies = TestJsoup.getAllImagesUrlByClassname("https://www.grandecran.fr/limoges-centre/films/","visuel_film");

		for (Movie movie : listOfMovies) {
			Boolean response = TestJsoup.downloadImageByUrl(movie.url(), movie.name());
			if (response) {
				System.out.println("Image " + movie.url() + " : Ok");
			} else {
				System.out.println("Image " + movie.url() + " : échec");
			}
		}

		System.out.println("Fin du téléchargement des images.");

	}

}