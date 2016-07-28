package com.gojavaonline3.shkurupiy.finalcore.ljubarets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by Denis Ljubarets on 7/10/16.
 * GoIT Java #3
 */
public class EXUADownloader extends AbstractFilesDownloader {

    private String extension;

    /**
     * Default constructor. Calls super constructor that validates URL.
     *
     * @param resource link to ex.ua page
     * @param location path to save files to
     * @param extension of files to search for
     * @throws PageNotFoundException
     */
    EXUADownloader(String resource, String location, String extension) throws PageNotFoundException {
        super(resource, location);
        this.extension = extension;
    }

    /**
     * Parse given page for file links
     *
     * @param page to parse
     * @return set of file links
     */
    @Override
    protected Set<FileLink> parsePage(String page) {
        Set<FileLink> fileLinks = new HashSet<>();

        try {
            Document doc = Jsoup.connect(page).get();
            Elements anchors = doc.select("a");

            for (Element anchor : anchors) {
                String href = anchor.attr("href");
                String title = anchor.attr("title");

                if (href.startsWith("/get") && title.endsWith(extension)) {
                    File file = new File(location + File.separator + title);
                    String host = new URL(page).getHost();
                    URL url = new URL("http://" + host + href);

                    FileLink fileLink = new FileLink(file, url);
                    fileLinks.add(fileLink);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return fileLinks;
    }

}
