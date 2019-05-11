package evaluator;

@FunctionalInterface
public interface IntEvaluator<T> {

    int evaluate(T t);
}
