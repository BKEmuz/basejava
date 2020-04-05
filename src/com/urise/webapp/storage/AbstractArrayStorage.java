package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getResumeIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("Error: Резюме uuid " + resume.getUuid() + " нет в хранилище");
        }
    }

    public void save(Resume resume) {
        int index = getResumeIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("Error: Резюме uuid " + resume.getUuid() + " уже есть в хранилище");
        } else if (size > STORAGE_LIMIT) {
            System.out.println("Error: Хранилище переполнено");
        } else if (index == -1) {
            insElement(resume, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getResumeIndex(uuid);
        if (index >= 0) {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        } else System.out.println("Error: Резюме uuid " + uuid + " нет в хранилище");
    }

    public Resume get(String uuid) {
        int index = getResumeIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("Error: Резюме uuid " + uuid + " нет в хранилище");
            return null;
        }
    }

    protected abstract int getResumeIndex(String uuid);

    protected abstract void insElement(Resume resume, int index);

    protected abstract void fillDeletedElement(int index);

    public int size() {
        return size;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }
}

