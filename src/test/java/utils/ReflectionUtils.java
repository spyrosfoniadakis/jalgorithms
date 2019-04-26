package utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

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
