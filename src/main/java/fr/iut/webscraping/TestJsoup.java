package fr.iut.webscraping;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestJsoup {

    public static ArrayList<String> getAllImagesUrlByClassname(String url, String classname) {

        ArrayList<String> listOfUrls = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> images = doc.getElementsByClass(classname);

            for (Element image : images) {
                String src = image.attributes().get("src");
                listOfUrls.add(src);
            }

        } catch (IOException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return listOfUrls;
    }

    public static Boolean downloadImageByUrl(String url) {

        File file = new File("");
        String separator = FileSystems.getDefault().getSeparator();
        String path = file.getAbsolutePath() + separator  + "downloads" + separator + "blabla.jpg";
        file = new File(path);

        try {
            Connection.Response response = Jsoup.connect(url).ignoreContentType(true).execute();
            FileOutputStream out = new FileOutputStream(file);
            out.write(response.bodyAsBytes());
            out.close();

        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }

        return true;
    }


}
