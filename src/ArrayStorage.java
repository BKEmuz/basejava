import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    int size = 0;

    void save(Resume r) {
        int i = 0;
        while (i < storage.length) {
            if (storage[i] == null) {
                storage[i] = r;
                this.size = ++i;
                break;
            }
            i++;
        }
    }

    Resume get(String uuid) {
        int i = 0;
        while (i < size) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
            i++;
        }
        return null;
    }

    void delete(String uuid) {
        int j;
        for (j = 0; j < storage.length; j++) {                  //поиск удаляемого элемента
            if (storage[j].uuid == uuid)
                break;
        }

        for (int k = j; k < storage.length - 1; k++) {           //сдвиг последующих элементов
            storage[k] = storage[k + 1];
        }
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}

