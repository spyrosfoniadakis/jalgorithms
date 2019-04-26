package utils;

public final class Numbers {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", Numbers.class.getSimpleName());

    private Numbers(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }

    // TODO: Part of a partial solution fo a counting sort for long integers
//    public static final Integer reduceToIntByModuloWith(Long number, int base){
//        return Integer.valueOf(reduceToIntByModuloWith(number.longValue(), base));
//    }
//
//    public static final int reduceToIntByModuloWith(long number, int base){
//        return (int)(number % base);
//    }
//
//    public static final Long reduceToIntByDividingWith(Long number, int base){
//        return Long.valueOf(reduceToIntByDividingWith(number.longValue(), base));
//    }
//
//    public static final long reduceToIntByDividingWith(long number, int base){
//        return number / base;
//    }
}
