package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Objects;

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


    public Resume get(String uuid) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        return storage[getIndex(uuid)];
    }

    protected abstract int getIndex(String uuid);


}