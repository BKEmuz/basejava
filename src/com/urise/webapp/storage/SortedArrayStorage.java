package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getResumeIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insElement(Resume resume, int index) {
//      https://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
        int insert = -index - 1;
        System.arraycopy(storage, insert, storage, insert + 1, size - insert);
        storage[insert] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }
}

