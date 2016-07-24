package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    public static final int LENGTH_STORAGE = 10000;

    protected Resume[] storage;
    protected int size;

    public AbstractArrayStorage() {
        storage = new Resume[LENGTH_STORAGE];
        size = 0;
    }

    public abstract int getIndex(String uuid);

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("ERROR: Can't do update. There is no resume with uuid=" + resume.getUuid() + " !");
        } else {
            //We must change other fields. Unique ID isn't updated.
            storage[index].setUuid(resume.getUuid());
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("ERROR: Can't do select. There is no resume with uuid=" + uuid + " !");
            return null;
        }
        return storage[index];
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    /*@Override
    public int getSize() {
        return size;
        }
    */
}