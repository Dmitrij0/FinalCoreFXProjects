package com.gojavaonline3.shkurupiy.finalcore.ljubarets;

import java.net.URL;

/**
 * Created by Denis Ljubarets on 7/4/16.
 * GoIT Java #3
 */
public class PageNotFoundException extends NotFoundException {

    PageNotFoundException(String page) {
        this.message = "Page not found :" +page;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
