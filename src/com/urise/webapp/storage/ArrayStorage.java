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

    public boolean inspection(Resume r) {
        for (int i = 0; i < size; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                System.out.println("This uuid " + r + " is already taken !!!");
                return true;
            }
        }
        return false;
    }

    public int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {

        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume r) {
        if (inspection(r)) {
            storage[getIndex(r.getUuid())] = r;
            System.out.println("Update successfully");
            return;
        } else {
            System.out.println("Error!this object " + r + " is absent");
        }
    }

    public void save(Resume r) {
        if (size == STORAGE_LIMIT) {
            System.out.println("Error! Massive has be full!!!");
            return;
        }
        if (inspection(r) == false) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Error! " + r + " is present in massive!enter another");
            return;
        }
    }

    public Resume get(String uuid) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        return storage[getIndex(uuid)];
    }

    public void delete(String uuid) {
        Objects.requireNonNull(uuid, "uuis must not be null");
        int index = getIndex(uuid);
        if(index>0){
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            return;
        }else{
            System.out.println("Error! " + uuid + " don't present in massive!enter another! ");
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

    public int size() {
        return size;
    }

}
