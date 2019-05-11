package evaluator;

@FunctionalInterface
public interface LongEvaluator<T> {

    long evaluate(T t);
}
