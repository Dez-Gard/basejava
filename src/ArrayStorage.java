import java.util.Arrays;
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    Resume save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
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
            } else {
                break;
            }
        }
        return storage[i];
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                System.arraycopy(storage, i + 1, storage, i, storage.length - (i + 1));
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] copyStorage = new Resume[0];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                copyStorage = Arrays.copyOfRange(storage, 0, i + 1);
            }
        }
        return copyStorage;
    }

    int size() {
        int s = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                s++;
            }
        }
        return s;
    }
}
