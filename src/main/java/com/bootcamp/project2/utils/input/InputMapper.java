package com.bootcamp.project2.utils.input;

import com.bootcamp.project2.utils.input.exceptions.MappingException;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class InputMapper {

    public static <T> T map(Class<T> clazz) throws MappingException {
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
}
