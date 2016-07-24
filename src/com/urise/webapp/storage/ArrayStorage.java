package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    protected static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void save(Resume r) {
        if (size == STORAGE_LIMIT) {
            System.out.println("Error! Massive has be full!!!");
            return;
        }
        if (!inspection(r)) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Error! " + r + "is present in massive!enter another ");
            return;
        }


    }

    public void delete(String uuid) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        int index = getIndex(uuid);
        if (index > 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            return;
        } else {
            System.out.println("Error! " + uuid + "don't present in massive ");
        }
    }

    @Override
    public boolean inspection(Resume r) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }

}