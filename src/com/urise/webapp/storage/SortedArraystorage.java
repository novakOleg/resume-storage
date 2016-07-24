package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArraystorage extends AbstractArrayStorage {

    public SortedArraystorage() {
        super();
    }

    @Override
    public void save(Resume resume) {
        if (LENGTH_STORAGE == size) {
            System.out.println("ERROR: Array resumes is full !");
            return;
        }
        if (getIndex(resume.getUuid()) < 0) {
            storage[size] = resume;           //add new element to end of array
            size++;
            Arrays.sort(storage, 0, size); //again sort array
        } else {
            System.out.println("ERROR: Can't do insert. " + resume + " is present !");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("ERROR: Can't do delete. There is no resume with uuid=" + uuid + " !");
        } else {
            storage[index] = storage[size - 1]; //last element became on place deleted one
            storage[size - 1] = null;            //last element became null
            size--;
            Arrays.sort(storage, 0, size);  //again sort array
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

    @Override
    public int getIndex(String uuid) {
        return Arrays.binarySearch(storage, 0, size, new Resume(uuid));
    }
}