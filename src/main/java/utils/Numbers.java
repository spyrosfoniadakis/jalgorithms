/*
 * Copyright 2019 Spyridon Foniadakis
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
