package com.gojavaonline3.shkurupiy.finalcore.ljubarets;

import java.io.IOException;

/**
 * Interface of downloader for any kinds of items
 *
 * Created by Denis Ljubarets on 7/10/16.
 * GoIT Java #3
 */
public interface Downloader {

    /**
     * Download items and return the number of downloaded
     *
     * @return number of downloaded items
     * @throws NotFoundException
     */
    int get() throws NotFoundException, IOException;

}
