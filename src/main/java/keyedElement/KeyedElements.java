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
package keyedElement;

import evaluator.DoubleEvaluator;
import evaluator.FloatEvaluator;
import evaluator.IntEvaluator;
import evaluator.LongEvaluator;

/**
 * @author Spyros Foniadakis
 */
public class KeyedElements {

    public static <T extends IntEvaluator<T>> IntKeyedElement<T>[] from(T[] elements){
        IntKeyedElement[] keyedElements = new IntKeyedElement[elements.length];
        int index = 0;
        for(T element : elements){
            keyedElements[index++] = IntKeyedElement.from(element);
        }
        return keyedElements;
    }

    public static <T extends LongEvaluator<T>> LongKeyedElement<T>[] from(T[] elements){
        LongKeyedElement[] keyedElements = new LongKeyedElement[elements.length];
        int index = 0;
        for(T element : elements){
            keyedElements[index++] = LongKeyedElement.from(element);
        }
        return keyedElements;
    }

    public static <T> LongKeyedElement<T>[] from(LongEvaluator<T> evaluator, T[] elements){
        LongKeyedElement[] keyedElements = new LongKeyedElement[elements.length];
        int index = 0;
        for(T element : elements){
            keyedElements[index++] = LongKeyedElement.from(evaluator.evaluate(), element);
        }
        return keyedElements;
    }

    public static <T extends FloatEvaluator<T>> FloatKeyedElement<T>[] from(T[] elements){
        FloatKeyedElement[] keyedElements = new FloatKeyedElement[elements.length];
        int index = 0;
        for(T element : elements){
            keyedElements[index++] = FloatKeyedElement.from(element);
        }
        return keyedElements;
    }

    public static <T> FloatKeyedElement<T>[] from(FloatEvaluator<T> evaluator, T[] elements){
        FloatKeyedElement[] keyedElements = new FloatKeyedElement[elements.length];
        int index = 0;
        for(T element : elements){
            keyedElements[index++] = FloatKeyedElement.from(evaluator.evaluate(), element);
        }
        return keyedElements;
    }

    public static <T extends DoubleEvaluator<T>> DoubleKeyedElement<T>[] from(T[] elements){
        DoubleKeyedElement[] keyedElements = new DoubleKeyedElement[elements.length];
        int index = 0;
        for(T element : elements){
            keyedElements[index++] = DoubleKeyedElement.from(element);
        }
        return keyedElements;
    }

    public static <T> DoubleKeyedElement<T>[] from(DoubleEvaluator<T> evaluator, T[] elements){
        DoubleKeyedElement[] keyedElements = new DoubleKeyedElement[elements.length];
        int index = 0;
        for(T element : elements){
            keyedElements[index++] = DoubleKeyedElement.from(evaluator.evaluate(), element);
        }
        return keyedElements;
    }
}
