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

import java.util.Calendar;
import java.util.Date;

/**
 * @author Spyros Foniadakis
 */
public class DateUtils {

    private static String INSTANTIATION_ERROR_MESSAGE = String.format("Class %s should not be initialized.", DateUtils.class.getSimpleName());

    private DateUtils(){
        throw new InstantiationError(INSTANTIATION_ERROR_MESSAGE);
    }

    private static final Calendar CALENDAR = Calendar.getInstance();

    public static Date getDateFrom(int year, int month, int day){
        CALENDAR.set(year, month, day);
        return CALENDAR.getTime();
    }
}
