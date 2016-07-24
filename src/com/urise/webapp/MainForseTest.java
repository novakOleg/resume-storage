package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.Storage;

/**
 * Created by 26nov on 24.07.2016.
 */
public class MainForseTest {

    public static final Storage STORAGE;

    static {
        STORAGE = new ArrayStorage();
        //		STORAGE=new SortedArrayStorage();
    }

    public static void main(String[] args) {
        STORAGE.save(new Resume());

    }
}