package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    protected static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {

        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }


    public void save(Resume r) {
        if (size == STORAGE_LIMIT) {
            System.out.println("Error! Massive has be full!!!");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (r.setUuid(r).equals(storage[i].getUuid())){
                System.out.println("This uuid is already taken !!! Please enter another !!!");
                return;
            }
        }
        storage[size] = r;
        size++;


    }

    public Resume get(String uuid) {
        Objects.requireNonNull(uuid, "uuis must not be null");
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        Objects.requireNonNull(uuid, "uuis must not be null");
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                return;
            }
        }
    }

    /*
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] fin = new Resume[size];
        int j = 0;

        for (int i = 0; i < size; i++) {
            fin[j] = storage[i];
            j++;
        }
        return fin;
    }

    public int size(){
        return size;
    }

}