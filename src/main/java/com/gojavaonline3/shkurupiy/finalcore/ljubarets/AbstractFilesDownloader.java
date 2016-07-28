package com.gojavaonline3.shkurupiy.finalcore.ljubarets;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;

/**
 * Created by Denis Ljubarets on 7/10/16.
 * GoIT Java #3
 */
public abstract class AbstractFilesDownloader implements Downloader {

    protected String resource;
    protected String location;

    /**
     * Default constructor.
     *
     * @param resource link to web page
     * @param location path to save files to
     * @throws PageNotFoundException if {@param resource} is not valid URL
     */
    AbstractFilesDownloader(String resource, String location) throws PageNotFoundException {
        try {
            HttpURLConnection huc = (HttpURLConnection) new URL(resource).openConnection();
            huc.setRequestMethod("GET");
            huc.connect();

            int responseCode = huc.getResponseCode();
            if (responseCode != 200 && responseCode != 201) {
                throw new IOException();
            }
        } catch (IOException e) {
            throw new PageNotFoundException(resource);
        }

        this.resource = resource;
        this.location = location;
    }

    /**
     * Parse given page for file links
     *
     * @param page to parse
     * @return set of file links
     */
    protected abstract Set<FileLink> parsePage(String page);

    /**
     * Downloads files to hard drive
     *
     * @return number of files downloaded
     * @throws NotFoundException
     */
    @Override
    public int get() throws NotFoundException, IOException {
        int count = 0;

        Set<FileLink> fileLinks = parsePage(resource);
        for (FileLink fileLink : fileLinks) {
            boolean downloaded = downloadFile(fileLink);

            if (downloaded) {
                count++;
            }
        }

        return count;
    }

    /**
     * Downloads single file from URL
     *
     * @param fileLink containing link
     * @return true if download succeeds, false if download fails
     * @throws IOException
     */
    private boolean downloadFile(FileLink fileLink) throws IOException {
        URL url = fileLink.getLink();
        File file = fileLink.getFile();

        FileUtils.copyURLToFile(url, file);

        return (file.exists() && file.length() > 0);
    }

}
