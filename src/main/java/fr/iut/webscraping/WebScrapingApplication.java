package fr.iut.webscraping;

import org.jsoup.Jsoup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class WebScrapingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebScrapingApplication.class, args);
//		ArrayList<String> listOfUrls = TestJsoup.getAllImagesUrlByClassname("https://www.grandecran.fr/limoges-centre/films/","visuel_film");
//		System.out.println(listOfUrls);
		TestJsoup.downloadImageByUrl("https://fr.web.img6.acsta.net/c_225_338_50_50/pictures/22/12/02/16/03/2536613.jpg");

	}

}
