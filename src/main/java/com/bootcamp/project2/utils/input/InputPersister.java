package com.bootcamp.project2.utils.input;

import com.bootcamp.project2.utils.input.exceptions.MappingException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Consumer;

public class InputPersister {

    public static <T> void requestInputAndPersist(Class<T> clazz, JpaRepository<T, Integer> repository) {
        requestInputAndPersist(clazz, repository, null);
    }

    public static <T> void requestInputAndPersist(Class<T> clazz, JpaRepository<T, Integer> repository, Consumer<T> mutator) {
        try {
            T entity = InputMapper.map(clazz);
            if (mutator != null) {
                mutator.accept(entity);
            }
            repository.save(entity);
            System.out.printf("-- %s created successfully! --%n", clazz.getSimpleName());
        } catch (MappingException e) {
            System.out.printf("-- Failed to create %s --%n", clazz.getSimpleName());
        }
    }
}
