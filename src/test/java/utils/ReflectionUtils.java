/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author Spyros Foniadakis
 */
public class ReflectionUtils {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", ReflectionUtils.class.getSimpleName());

    private ReflectionUtils(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }

    public static Object getFieldValueOf(Object object, String className, String fieldName) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class c = Class.forName(className);
        Field[] fields = c.getDeclaredFields();
        Optional<Field> optionalField = Arrays.stream(fields).filter(f->f.getName().equals(fieldName)).findFirst();

        while(!optionalField.isPresent() && (c = c.getSuperclass()) != null){
            optionalField = Arrays.stream(c.getDeclaredFields()).filter(f->f.getName().equals(fieldName)).findFirst();
        }

        Field field = optionalField.orElseThrow(() -> new NoSuchFieldException());
        field.setAccessible(true);
        return field.get(object);
    }

//    public static Object executeMethodOf(Object object, String className, String methodName) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
//        Class c = Class.forName(className);
//        Method method= c.getMethod();
//        Optional<Field> optionalField = Arrays.stream(fields).filter(f->f.getName().equals(fieldName)).findFirst();
//
//        while(!optionalField.isPresent() && (c = c.getSuperclass()) != null){
//            optionalField = Arrays.stream(c.getDeclaredFields()).filter(f->f.getName().equals(fieldName)).findFirst();
//        }
//
//        Field field = optionalField.orElseThrow(() -> new NoSuchFieldException());
//        field.setAccessible(true);
//        return field.get(object);
//    }
}
