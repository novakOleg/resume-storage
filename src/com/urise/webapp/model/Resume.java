package com.urise.webapp.model;

public class Resume implements Comparable<Resume> {
    private String uuid;

    public Resume() {
        uuid = new String();
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Resume [uuid=" + uuid + "]";
    }

    @Override
    public boolean equals(Object resume) {
//       Check java.lang.ClassCastException
        if (resume instanceof Resume) {
            Resume r1 = (Resume) resume;
            return uuid.equals(r1.getUuid());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.getUuid());
    }
}