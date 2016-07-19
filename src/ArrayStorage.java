import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    protected static final int STORAGE_LIMIT = 10000;
    Resume[] storage = new Resume[STORAGE_LIMIT];
    int size = 0;

    void clear() {

        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (size == STORAGE_LIMIT) {
            System.out.println("Error! Massive has be full!!!");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (r.uuid.equals(storage[i].uuid)) {
                System.out.println("This uuid is already taken !!! Please enter another !!!");
                return;
            }
        }
        storage[size] = r;
        size++;


    }

    Resume get(String uuid) {
        Objects.requireNonNull(uuid, "uuis must not be null");
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        Objects.requireNonNull(uuid, "uuis must not be null");
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
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
    Resume[] getAll() {
        Resume[] fin = new Resume[size];
        int j = 0;

        for (int i = 0; i < size; i++) {
            fin[j] = storage[i];
            j++;
        }
        return fin;
    }

}