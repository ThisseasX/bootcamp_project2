package com.bootcamp.project2.utils.iteration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@Getter
public class IndexedList<T> implements Iterable<IndexedEntry<T>> {

    private final List<T> list;

    @Override
    public Iterator<IndexedEntry<T>> iterator() {
        return new Iterator<IndexedEntry<T>>() {

            private int index;
            private Iterator<T> iterator = list.iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public IndexedEntry<T> next() {
                return new IndexedEntry<>(index++, iterator.next());
            }
        };
    }
}
