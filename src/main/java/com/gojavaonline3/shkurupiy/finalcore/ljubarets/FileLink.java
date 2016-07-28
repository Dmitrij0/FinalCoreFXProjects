package com.gojavaonline3.shkurupiy.finalcore.ljubarets;

import java.io.File;
import java.net.URL;

/**
 * Created by Denis Ljubarets on 7/3/16.
 * GoIT Java #3
 */
public class FileLink {
    
    private final File file;
    private final URL link;

    public File getFile() {
        return file;
    }

    public URL getLink() {
        return link;
    }

    public FileLink(File file, URL link) {
        this.file = file;
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileLink fileLink = (FileLink) o;

        return link != null ? link.equals(fileLink.link) : fileLink.link == null;

    }

    @Override
    public int hashCode() {
        return link != null ? link.hashCode() : 0;
    }
}
