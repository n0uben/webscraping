package fr.iut.webscraping;

import org.jsoup.Jsoup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class WebScrapingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebScrapingApplication.class, args);
		ArrayList<String> listOfUrls = TestJsoup.getAllImagesUrlByClassname("https://www.grandecran.fr/limoges-centre/films/","visuel_film");

		Integer i = 0;
		for (String url : listOfUrls) {
			TestJsoup.downloadImageByUrl(url, "image" + i);
			i++;
		}

		System.out.println("tadaaaaaaaa");

	}

}
