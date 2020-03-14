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

    void save(Resume r) {
        int i = 0;
        while (i < storage.length) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
            i++;
        }
    }

    Resume get(String uuid) {
        int i = 0;
        while (i < storage.length) {
           if (storage[0] == null) {
               break;
           } else if (storage[i].uuid == uuid) {
                return storage[i];
            }
            i++;
        }
        return null;
    }

    void delete(String uuid) {
        int nElems = storage.length;                    //количество элементов
        int j;                                          //счетчик цикла
        String searchKey;                               //ключи искомого элемента
        searchKey = uuid;                               //удаление элемента с ключом  uuid

        for (j = 0; j < nElems; j++) {                  //поиск удаляемого элемента
            if (storage[j].uuid == searchKey)
                break;
        }

        for (int k = j; k < nElems - 1; k++) {           //сдвиг последующих элементов
            storage[k] = storage[k + 1];
            nElems--;
        }
    }
        /**
         * @return array, contains only Resumes in storage (without null)
         */

        private int nL;
        Resume[] getAll () {

            for (int i = 0; i < storage.length; i++) {
                if (storage[i] == null) {
                    nL = i;
                    break;
                }
            }
            return Arrays.copyOfRange(storage, 0, nL);
        }

        int size () {
            return getAll().length;
        }
}

