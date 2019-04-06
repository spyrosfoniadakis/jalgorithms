package utils;

public final class ArrayUtils {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", ArrayUtils.class.getSimpleName());

    private ArrayUtils(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }


    public static void swap(int[] numbers, int index1, int index2) {
        int tmp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = tmp;
    }

    public static void swap(long[] numbers, int index1, int index2) {
        long tmp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = tmp;
    }

    public static void swap(float[] numbers, int index1, int index2) {
        float tmp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = tmp;
    }

    public static void swap(double[] numbers, int index1, int index2) {
        double tmp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = tmp;
    }

    public static <T> void swap(T[] numbers, int index1, int index2) {
        T tmp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = tmp;
    }

    public static int indexOfMax(int[] numbers){
        if(numbers.length == 0){
            throw new IllegalArgumentException("Array must have at least one element.");
        }
        int maxIndex = 0;
        for(int i=1; i<numbers.length; i++){
            maxIndex = (numbers[maxIndex] < numbers[i]) ? i : maxIndex;
        }
        return maxIndex;
    }
}
