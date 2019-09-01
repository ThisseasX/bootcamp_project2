package com.bootcamp.project2.utils.iteration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@Getter
public class IndexedList<T> implements Iterable<IndexedList.Entry<T>> {

    private final List<T> list;

    @Override
    public Iterator<IndexedList.Entry<T>> iterator() {
        return new Iterator<IndexedList.Entry<T>>() {

            private int index;
            private final Iterator<T> iterator = list.iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public IndexedList.Entry<T> next() {
                return new IndexedList.Entry<>(index++, iterator.next());
            }
        };
    }

    @AllArgsConstructor
    @Getter
    public static class Entry<T> {
        int index;
        T value;
    }
}
