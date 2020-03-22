package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        if (getResumeIndex(resume.getUuid()) >= 0) {
            storage[getResumeIndex(resume.getUuid())] = resume;
        } else {
            System.out.println("Error: Резюме нет в хранилище");
        }
    }

    public void save(Resume resume) {
        System.out.println(getResumeIndex(resume.getUuid()));
        int index = getResumeIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("Error: Резюме есть в хранилище");
        } else if (size > storage.length) {
            System.out.println("Error: Хранилище переполнено");
        } else if (index == -1) {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        if (getResumeIndex(uuid) >= 0) {
            return storage[getResumeIndex(uuid)];
        } else {
            System.out.println("Error: Резюме нет в хранилище");
            return null;
        }
    }

    public void delete(String uuid) {
        if (getResumeIndex(uuid) >= 0) {
            storage[getResumeIndex(uuid)] = storage[size - 1];
            storage[size - 1] = storage[size];
            size--;
        } else System.out.println("Error: Резюме нет в хранилище");
    }

    public int getResumeIndex(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
                break;
            } else {
                index = -1;
            }
        }
        return index;
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

