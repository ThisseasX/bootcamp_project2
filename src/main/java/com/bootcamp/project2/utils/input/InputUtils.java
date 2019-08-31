package com.bootcamp.project2.utils.input;

import com.bootcamp.project2.utils.input.exceptions.MappingException;
import com.bootcamp.project2.utils.iteration.IndexedList;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.function.Consumer;

public class InputUtils {

    public static <T> T mapInputToEntity(Class<T> clazz) throws MappingException {
        try {
            Scanner sc = new Scanner(System.in);
            T mappedEntity = clazz.getDeclaredConstructor().newInstance();

            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(Column.class)) {
                    System.out.printf("Please input a %s:%n", f.getName());

                    f.setAccessible(true);
                    f.set(mappedEntity, sc.next());
                }
            }

            return mappedEntity;

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new MappingException(e);
        }
    }

    public static <T> T requestEntityChoice(JpaRepository<T, Integer> repository, String prompt) {
        Scanner sc = new Scanner(System.in);
        IndexedList<T> list = new IndexedList<>(repository.findAll());

        while (true) {
            System.out.println(prompt);
            list.forEach(entry -> System.out.printf("%s) %s%n", entry.getIndex() + 1, entry.getValue()));

            try {
                return list.getList().get(Integer.parseInt(sc.next()) - 1);
            } catch (Exception e) {
                System.out.println("-- Invalid number, please type the number of the desired Course --");
            }
        }
    }

    public static <T> void requestInputAndPersist(Class<T> clazz, JpaRepository<T, Integer> repository) {
        requestInputAndPersist(clazz, repository, null);
    }

    public static <T> void requestInputAndPersist(Class<T> clazz, JpaRepository<T, Integer> repository, Consumer<T> mutator) {
        try {
            T entity = mapInputToEntity(clazz);
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
