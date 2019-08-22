package com.bootcamp.project2.utils.iteration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IndexedEntry<T> {

    int index;
    T value;
}
