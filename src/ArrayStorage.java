import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int size = 0;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    Resume save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (i == size) {
                storage[i] = r;
                size++;
                break;
            }
        }
        return r;
    }

    Resume get(String uuid) {
        int i;
        for (i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                size--;
                System.arraycopy(storage, i + 1, storage, i, i + 1);
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] copyStorage;
        copyStorage = Arrays.copyOfRange(storage, 0, size);
        return copyStorage;
    }

    int size() {
        return size;
    }
}
