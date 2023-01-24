package fr.iut.webscraping;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;

public class TestJsoup {

    public static ArrayList<Movie> getAllImagesUrlByClassname(String url, String classname) {

        ArrayList<Movie> listOfMovies = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> images = doc.getElementsByClass(classname);

            for (Element image : images) {
                String src = image.attr("src").trim();
                //remplacement des deux points par un tiret dans les alts
                // car ca fait planter l'écriture des fichiers sur le disque pour une raison inconnue
                String name = image.attr("alt").replace(":", "-").trim();
                listOfMovies.add(new Movie(name, src));
            }

        } catch (IOException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return listOfMovies;
    }

    public static Boolean downloadImageByUrl(String url, String name) {

        File file = new File("");
        String separator = FileSystems.getDefault().getSeparator();
        String path = file.getAbsolutePath() + separator  + "downloads" + separator + name + ".jpg";
        file = new File(path);

        try {
            Connection.Response response = Jsoup.connect(url).ignoreContentType(true).execute();
            FileOutputStream out = new FileOutputStream(file);
            out.write(response.bodyAsBytes());
            out.close();

        } catch (IOException ioException) {
            System.out.println(ioException.getLocalizedMessage());
            return false;
        }

        return true;
    }


}