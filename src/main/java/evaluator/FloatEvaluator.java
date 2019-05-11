package evaluator;

@FunctionalInterface
public interface FloatEvaluator<T> {

    float evaluate(T t);
}
