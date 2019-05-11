package evaluator;

@FunctionalInterface
public interface DoubleEvaluator<T> {

    double evaluate(T t);
}
