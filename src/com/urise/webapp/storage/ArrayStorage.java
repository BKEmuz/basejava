package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int j;
        int index = 0;
        for (j = 0; j < size; j++) {
            if (storage[j].getUuid() == r.getUuid()) {
                index = 1;
                break;
            }
        }
        if (index == 1) {
            storage[j] = r;
        } else {
            System.out.println("Error: Резюме нет в хранилище");
        }
    }

    public void save(Resume r) {
        int j;
        int index = 0;
        for (j = 0; j < size; j++) {
            if (storage[j].getUuid() == r.getUuid()) {
                index = 1;
                break;
            }
        }

        if (index == 1) {
            System.out.println("Error: Резюме есть в хранилище");
        } else if (size > storage.length) {
            System.out.println("Error: Хранилище переполнено");
        } else if (index != 1) {
            storage[j] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int j;
        int index = 0;
        for (j = 0; j < size; j++) {
            if (storage[j].getUuid() == uuid) {
                index = 1;
                break;
            }
        }

        if (index == 1) {
            int i = 0;
            while (i < size) {
                if (storage[i].getUuid() == uuid) {
                    return storage[i];
                }
                i++;
            }
        } else
            System.out.println("Error: Резюме нет в хранилище");
        return null;
    }

    public void delete(String uuid) {
        int j;
        int index = 0;
        for (j = 0; j < size; j++) {
            if (storage[j].getUuid() == uuid) {
                index = 1;
                break;
            }
        }
        if (index == 1) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid() == uuid) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = storage[size];
                    size--;
                }
            }
        } else System.out.println("Error: Резюме нет в хранилище");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}

