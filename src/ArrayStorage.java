import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }

        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
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
        if (!uuid.equals("null")) {
            for (j = 0; j < size; j++) {                  //поиск удаляемого элемента
                if (storage[j].uuid == uuid)
                    break;
            }

            for (int k = j; k < size - 1; k++) {           //сдвиг последующих элементов
                storage[k] = storage[k + 1];
            }

            size--;
        }
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

