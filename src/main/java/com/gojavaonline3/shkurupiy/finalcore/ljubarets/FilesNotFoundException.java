package com.gojavaonline3.shkurupiy.finalcore.ljubarets;

/**
 * Created by Denis Ljubarets on 7/4/16.
 * GoIT Java #3
 */
public class FilesNotFoundException extends NotFoundException {

    FilesNotFoundException(String extension) {
        this.message = extension+ " files not found";
    }

    @Override
    public String getMessage() {
        return message;
    }

}
