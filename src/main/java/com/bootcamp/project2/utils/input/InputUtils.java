package com.bootcamp.project2.utils.input;

import com.bootcamp.project2.utils.input.exceptions.MappingException;
import com.bootcamp.project2.utils.iteration.IndexedList;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.function.Consumer;

public class InputUtils {

    /**
     * Reflectively analyze the given class and map the user input
     * to the entity's fields marked with {@link Column} annotation.
     *
     * @param clazz The desired class to be created and mapped.
     * @param <T>   An entity with String-type @Column-annotated fields.
     * @return Returns a filled entity of the given class.
     * @throws MappingException Thrown in case of a reflection error.
     */
    public static <T> T mapInputToEntity(Class<T> clazz) throws MappingException {
        try {
            Scanner sc = new Scanner(System.in);

            T mappedEntity = clazz.getDeclaredConstructor().newInstance();

            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(Column.class)) {
                    System.out.printf("Please input a %s:%n", f.getName());

                    f.setAccessible(true);
                    f.set(mappedEntity, sc.nextLine());
                }
            }

            return mappedEntity;

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new MappingException(e);
        }
    }

    /**
     * Ask the user to choose an existing entity.
     *
     * @param repository The repository used to fetch the entity.
     * @param prompt     The question to be printed.
     * @param <T>        An entity to be chosen.
     * @return Returns the chosen entity.
     */
    public static <T> T requestEntityChoice(JpaRepository<T, Integer> repository, String prompt) {
        Scanner sc = new Scanner(System.in);
        IndexedList<T> list = new IndexedList<>(repository.findAll());

        if (list.getList().size() == 0) {
            System.out.println(prompt);
            System.out.println("-- There are no items to choose from, please add some --");
            return null;
        }

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

    /**
     * Overload of {@link InputUtils#requestInputAndPersist(Class, JpaRepository, Consumer)} without a mutator.
     */
    public static <T> void requestInputAndPersist(Class<T> clazz, JpaRepository<T, Integer> repository) {
        requestInputAndPersist(clazz, repository, null);
    }

    /**
     * Uses the above methods to create a new entity filled with the user's input and
     * save it to the database using the given repository. Optionally accepts a mutator,
     * used to give the ability to manipulate the entity before it is saved, e.g. filling
     * non-Column fields with other means, such as a separate call to {@link InputUtils#requestEntityChoice(JpaRepository, String)}.
     *
     * @param clazz      The desired class to be created and saved.
     * @param repository The repository used to save the entity.
     * @param mutator    (Optional) A {@link Consumer} that can be used to fill the entity's fields through other means.
     * @param <T>        An entity to be created and saved.
     */
    public static <T> void requestInputAndPersist(Class<T> clazz, JpaRepository<T, Integer> repository, Consumer<T> mutator) {
        try {
            T entity = mapInputToEntity(clazz);

            if (mutator != null) {
                mutator.accept(entity);
            }

            repository.save(entity);
            System.out.printf("-- %s: [%s] was successfully saved --%n", clazz.getSimpleName(), entity);

        } catch (MappingException | DataIntegrityViolationException e) {
            System.out.printf("-- Failed to create %s --%n", clazz.getSimpleName());
        }
    }
}
