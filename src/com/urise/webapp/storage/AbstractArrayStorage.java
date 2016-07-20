package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Created by 26nov on 20.07.2016.
 */
public abstract class AbstractArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }
}