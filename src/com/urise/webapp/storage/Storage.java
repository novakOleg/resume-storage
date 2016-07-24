package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Created by 26nov on 20.07.2016.
 */
public interface Storage {

    void clear();

    void update(Resume r);

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    boolean inspection(Resume r);

    int size();

}
